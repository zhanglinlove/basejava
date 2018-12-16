package com.core.java;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutionException;

public class SimpleAioClient {

	static final int port = 9999;
	public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
		AsynchronousSocketChannel socketChannel = AsynchronousSocketChannel.open();
		ByteBuffer buff = ByteBuffer.allocate(1024);
		Charset utf = Charset.forName("utf-8");
		socketChannel.connect(new InetSocketAddress("127.0.0.1", port)).get();
		buff.clear();
		socketChannel.read(buff).get();
		buff.flip();
		String content = utf.decode(buff).toString();
		System.out.println("服务器信息：" + content);
	}

}
