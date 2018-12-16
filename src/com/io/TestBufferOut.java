package com.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestBufferOut {

	private static byte[] message = {0, 1, 2, 3, 4, 5, 6};
	
	public static void main(String[] args) throws IOException {
		String name = "F:/密码.txt";
		FileOutputStream out = new FileOutputStream(name, true);
		FileChannel fileChannel = out.getChannel();
		ByteBuffer bf = ByteBuffer.allocate(1024);
		bf.put("\nhello ,test".getBytes());
		bf.flip();
		fileChannel.write(bf);
		fileChannel.close();
	}

}
