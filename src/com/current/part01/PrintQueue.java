package com.current.part01;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {

	private Lock queueLock = new ReentrantLock(true);
	
	public void printJob() {
		queueLock.lock();
		try {
			long d = (long) (Math.random() * 10);
			System.out.println(Thread.currentThread().getName() + 
					"print a thread at " + d + " second.");
			TimeUnit.SECONDS.sleep(d);
		} catch (InterruptedException e) {
			
		} finally {
			queueLock.unlock();
		}
		queueLock.lock();
		try {
			long d = (long) (Math.random() * 10);
			System.out.println(Thread.currentThread().getName() + 
					"print a thread at " + d + " second.");
			TimeUnit.SECONDS.sleep(d);
		} catch (InterruptedException e) {
			
		} finally {
			queueLock.unlock();
		}
		
	}
}
