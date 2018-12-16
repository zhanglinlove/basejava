package com.current.part06;

import java.util.concurrent.ConcurrentLinkedDeque;

public class Test {

	public static void main(String[] args) {
		ConcurrentLinkedDeque<String> list = new ConcurrentLinkedDeque<String>();
		Thread[] threads = new Thread[50];
		for (int i = 0; i < threads.length; i++) {
			AddTask t = new AddTask(list);
			threads[i] = new Thread(t);
			threads[i].start();
		}
		System.out.println("addTask has been launch.");
		for (int i = 0; i < threads.length; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("size of list :" + list.size());
		for (int i = 0; i < threads.length; i++) {
			PollTask p = new PollTask(list);
			threads[i] = new Thread(p);
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
		System.out.println("size of the list:" + list.size());
	}
}
