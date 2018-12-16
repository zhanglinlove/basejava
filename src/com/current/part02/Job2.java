package com.current.part02;

public class Job2 implements Runnable{

	private PrintQueue2 printQueue;
	
	public Job2(PrintQueue2 printQueue) {
		this.printQueue = printQueue;
	}
	
	public void run() {
		System.out.printf("%s start to print a job.\n", Thread.currentThread().getName());
		printQueue.printJob(new Object());
		System.out.printf("%s the document has been print.\n", Thread.currentThread().getName());
	}

	
}
