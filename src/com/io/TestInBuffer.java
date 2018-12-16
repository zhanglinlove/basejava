package com.io;

import java.nio.ByteBuffer;

public class TestInBuffer {

	public static void main(String[] args) {
		ByteBuffer bf = ByteBuffer.allocate(1024);
		for (int i = 0; i < 10; i++) {
			bf.put((byte)i);
		}
		bf.flip();
		while (bf.hasRemaining()) {
			System.out.println(bf.get());
		}
	}

}
