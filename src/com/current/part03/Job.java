package com.current.part03;

public class Job implements Runnable{

	private PrintQueue printQueue;
	
	public Job(PrintQueue printQueue) {
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
