package com.current.part06;

import java.util.concurrent.PriorityBlockingQueue;

public class Task implements Runnable{

	private int id;
	private PriorityBlockingQueue<Event> queue;
	
	public Task(PriorityBlockingQueue<Event> queue, int id) {
		this.queue = queue;
		this.id = id;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 1000; i++) {
			Event e = new Event(id, i);
			queue.add(e);
		}
	}

}
