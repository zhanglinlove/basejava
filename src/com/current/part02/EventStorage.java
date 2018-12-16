package com.current.part02;

import java.util.Date;
import java.util.LinkedList;

public class EventStorage {

	private int maxSize;
	private LinkedList<Date> storage;
	
	public EventStorage() {
		this.maxSize = 10;
		storage = new LinkedList<>();
	}
	
	public synchronized void set() {
		while (maxSize == storage.size()) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		storage.add(new Date());
		System.out.println("set:" + storage.size());
		notifyAll();
	}
	
	public synchronized void get() {
		while (storage.size() == 0 ) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		storage.poll();
		System.out.println("get:" + storage.size());
		notifyAll();
	}
}
