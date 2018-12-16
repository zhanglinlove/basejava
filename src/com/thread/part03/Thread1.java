package com.thread.part03;

import java.io.PipedWriter;

public class Thread1 extends Thread{

	private WriteData data;
	private PipedWriter write;
	
	public Thread1(WriteData data, PipedWriter write) {
		this.data = data;
		this.write = write;
	}

	@Override
	public void run() {
		data.writeMethod(write);
	}
	
}
