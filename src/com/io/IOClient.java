package com.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class IOClient {

	private int port = 8888;
	private ByteBuffer send = ByteBuffer.allocate(1024);
	private ByteBuffer receive = ByteBuffer.allocate(1024);
	private SocketChannel socket = null;
	private Selector selector = null;
	
	public static void main(String[] args) throws IOException {
		IOClient client = new IOClient();
		client.start();
	}

	public IOClient() throws IOException {
		socket = SocketChannel.open();
		socket.configureBlocking(false);
		selector = Selector.open();
		socket.register(selector, SelectionKey.OP_CONNECT);
		socket.connect(new InetSocketAddress(port));
	}
	
	public void start() throws IOException {
		Iterator<SelectionKey> it = null;
		SocketChannel channel = null;
		while (true) {
			selector.select();
			it = selector.selectedKeys().iterator();
			while (it.hasNext()) {
				SelectionKey key = it.next();
				it.remove();
				if (key.isConnectable()) {
					System.out.println("client connent");
					channel = (SocketChannel) key.channel();
					if (channel.isConnectionPending()) {
						channel.finishConnect();
						String text = "client send info";
						send.clear();
						send.put(text.getBytes());
						send.flip();
						channel.write(send);
					}
					channel.register(selector, SelectionKey.OP_READ);
				} else if (key.isReadable()) {
					channel = (SocketChannel) key.channel();
					receive.clear();
					int count = channel.read(receive);
					if (count > 0) {
						String s = new String(receive.array(), 0, count);
						System.out.println("client read info:" + s);
						channel.register(selector, SelectionKey.OP_WRITE);
					}
					
				} else if (key.isWritable()) {
					channel = (SocketChannel) key.channel();
					send.clear();
					send.put("client write info...".getBytes());
					send.flip();
					channel.write(send);
					channel.register(selector, SelectionKey.OP_READ);
					System.out.println("客户端向服务器端发送数据--："); 
				}
			}
		}
	}
}
