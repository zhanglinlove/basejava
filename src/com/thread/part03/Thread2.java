package com.thread.part03;

import java.io.PipedReader;

public class Thread2 extends Thread{

	private ReadData data;
	private PipedReader read;
	
	public Thread2(ReadData data, PipedReader read) {
		this.data = data;
		this.read = read;
	}

	@Override
	public void run() {
		data.readMethod(read);
	}
	
}
