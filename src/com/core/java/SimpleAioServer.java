package com.core.java;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class SimpleAioServer {

	static final int port = 9999;
	public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
		AsynchronousServerSocketChannel serverChannel = AsynchronousServerSocketChannel.open();
		serverChannel.bind(new InetSocketAddress(port));
		while (true) {
			Future<AsynchronousSocketChannel> future = serverChannel.accept();
			AsynchronousSocketChannel socketChannel = future.get();
			socketChannel.write(ByteBuffer.wrap("欢迎你来自AIO的世界！".getBytes("UTF-8"))).get();
		}
	}

}
