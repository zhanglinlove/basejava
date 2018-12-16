package com.current.part01;

public class MyThread implements Runnable{

	private PrintQueue printQueue;
	
	public MyThread(PrintQueue printQueue) {
		this.printQueue = printQueue;
	}
	
	public void run() {
		printQueue.printJob();
	}

}
