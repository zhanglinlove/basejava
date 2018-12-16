package com.current.part06;

import java.util.concurrent.PriorityBlockingQueue;

public class Test3 {

	public static void main(String[] args) {
		PriorityBlockingQueue<Event> queue = new PriorityBlockingQueue<>();
		Thread[] threads = new Thread[5];
		for (int i = 0; i < threads.length; i++) {
			Task t = new Task(queue, i);
			threads[i] = new Thread(t);
		}
		for (int i = 0; i < threads.length; i++) {
			threads[i].start();
		}
		for (int i = 0; i < threads.length; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("queue size:" + queue.size());
		for (int i = 0; i < threads.length * 1000; i++) {
			Event event = queue.poll();
			System.out.println("Thread:" + event.getThread() + ";Priority:" + event.getPriority());
		}
		System.out.println("queue size:" + queue.size());
		System.out.println("end of program.");
	}
}
