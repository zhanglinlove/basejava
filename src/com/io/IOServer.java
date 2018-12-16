package com.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class IOServer {

	private int port = 8888;
	private Selector selector;
	private ByteBuffer send = ByteBuffer.allocate(1024);
	private ByteBuffer receive = ByteBuffer.allocate(1024);
	
	
	public static void main(String[] args) throws IOException {
		IOServer server = new IOServer();
		server.listen();
	}

	public IOServer() throws IOException {
		ServerSocketChannel socketChannel = ServerSocketChannel.open();
		ServerSocket socket = socketChannel.socket();
		socket.bind(new InetSocketAddress(port));
		socketChannel.configureBlocking(false);
		selector = Selector.open();
		socketChannel.register(selector, SelectionKey.OP_ACCEPT);
		System.out.println("-start accept...");
	}
	
	public void listen() throws IOException {
		while (true) {
			selector.select();
			Iterator<SelectionKey> it = selector.selectedKeys().iterator();
			while (it.hasNext()) {
				SelectionKey key = it.next();
				it.remove();
				handle(key);
			}
		}
	}
	
	public void handle(SelectionKey key) throws IOException {
		ServerSocketChannel serverChannel = null;
		SocketChannel client = null;
		if (key.isAcceptable()) {
			serverChannel = (ServerSocketChannel) key.channel();
			client = serverChannel.accept();
			client.configureBlocking(false);
			client.register(selector, SelectionKey.OP_READ);
			
		} else if (key.isReadable()) {
			client = (SocketChannel) key.channel();
			receive.clear();
			int count = client.read(receive);
			if (count > 0) {
				String s = new String(receive.array(), 0 ,count);
				System.out.println("接收的数据是:" + s);
				client.register(selector, SelectionKey.OP_WRITE);
			}
		} else if (key.isWritable()) {
			client = (SocketChannel) key.channel();
			send.clear();
			String text = "send info to client...";
			send.put(text.getBytes());
			send.flip();
			client.write(send);
			System.out.println("向客户器端发送数据:" + text);
			client.register(selector, SelectionKey.OP_READ);
		}
	}
}
