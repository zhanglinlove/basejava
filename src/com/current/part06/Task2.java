package com.current.part06;

import java.util.Date;
import java.util.concurrent.DelayQueue;

public class Task2 implements Runnable{

	private int id;
	private DelayQueue<Event2> queue;
	
	public Task2(int id, DelayQueue<Event2> queue) {
		this.id = id;
		this.queue = queue;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Date now = new Date();
		Date delay = new Date();
		delay.setTime(now.getTime() + id * 10000);
		System.out.println("thread " + id + ":" + delay);
		for (int i = 0; i < 100; i++) {
			Event2 event = new Event2(delay);
			queue.add(event);
		}
	}

}
