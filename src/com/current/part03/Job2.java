package com.current.part03;

public class Job2 implements Runnable{

	private PrintQueue2 printQueue;
	
	public Job2(PrintQueue2 printQueue) {
		this.printQueue = printQueue;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() +
					" start to print.");
		printQueue.printJob(new Object());
		System.out.println(Thread.currentThread().getName() +
					" end to print.");
	}

}
