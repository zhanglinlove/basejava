package com.thread.part04;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService3 {

	private Lock lock = new ReentrantLock();
	private Condition c1 = lock.newCondition();
	private Condition c2 = lock.newCondition();
	
	public void await() {
		try {
			lock.lock();
			System.out.println("begin await时间" + System.currentTimeMillis() 
				+ " threadName=" + Thread.currentThread().getName());
			c1.await();
			System.out.println("end await时间" + System.currentTimeMillis() 
			+ " threadName=" + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			
		} finally {
			lock.unlock();
		}
	}
	
	public void awaitB() {
		try {
			lock.lock();
			System.out.println(" begin awaitB时间" + System.currentTimeMillis() 
				+ " threadName=" + Thread.currentThread().getName());
			c2.await();
			System.out.println(" end awaitB时间" + System.currentTimeMillis() 
			+ " threadName=" + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			
		} finally {
			lock.unlock();
		}
	}
	
	public void signal_all() {
		try {
			lock.lock();
			System.out.println("start signal_all时间" + System.currentTimeMillis() 
			+ " threadName=" + Thread.currentThread().getName());
			c1.signalAll();
		} finally {
			lock.unlock();
		}
	}
	
	public void signal_B() {
		try {
			lock.lock();
			System.out.println("start signal_B时间" + System.currentTimeMillis() 
			+ " threadName=" + Thread.currentThread().getName());
			c2.signalAll();
		} finally {
			lock.unlock();
		}
	}
} 
