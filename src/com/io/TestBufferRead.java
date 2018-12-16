package com.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestBufferRead {

	public static void main(String[] args) throws IOException {
		FileInputStream file = new FileInputStream(new File("F:/密码.txt"));
		FileChannel channel = file.getChannel();
		ByteBuffer bf = ByteBuffer.allocate(1024);
		int count = channel.read(bf);
		System.out.println(new String(bf.array(), 0 , count));
	}
}
