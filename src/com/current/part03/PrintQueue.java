package com.current.part03;

import java.util.concurrent.Semaphore;

public class PrintQueue {

	private final Semaphore semaphore;
	
	public PrintQueue() {
		this.semaphore = new Semaphore(1);
	}
	
	public void printJob(Object document) {
		try {
			semaphore.acquire();
			long d = (long) (Math.random() * 10);
			System.out.println(Thread.currentThread().getName() +
						"; printJob during :" + d);
			Thread.sleep(d);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			semaphore.release();
		}
	}
	
	
}
