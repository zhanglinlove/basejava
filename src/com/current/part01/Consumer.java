package com.current.part01;

import java.util.Random;

public class Consumer implements Runnable{

	private Buffer buffer;
	public Consumer(Buffer buffer) {
		this.buffer = buffer;
	}
	public void run() {
		while (buffer.hasPendingLines()) {
			String line = buffer.get();
			proccessLine(line);
		}
	}

	public void proccessLine(String line) {
		
		try {
			Random r = new Random();
			Thread.sleep(r.nextInt(100));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
