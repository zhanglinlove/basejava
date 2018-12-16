package com.current.part02;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
/**
 * Semaphore控制访问数量。
 * @author zhanglin
 *
 */
public class PrintQueue {

	private final Semaphore semaphore;
	
	public PrintQueue() {
		semaphore = new Semaphore(1);
	}
	
	public void printJob(Object document) {
		try {
			semaphore.acquire();
			long duration = (long) (Math.random() * 10);
			System.out.printf("%s: printqueue: printing a job during %d seconds\n", 
					Thread.currentThread().getName(), duration);
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			
		} finally {
			semaphore.release();
		}
	}
	
	
}
