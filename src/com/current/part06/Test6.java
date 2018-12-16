package com.current.part06;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class Test6 {

	public static void main(String[] args) {
		final int THREADS = 100;
		AtomicIntegerArray atomic = new AtomicIntegerArray(1000);
		Incrementer incre = new Incrementer(atomic);
		Decrementer decre = new Decrementer(atomic);
		
		Thread[] increThreads = new Thread[THREADS];
		Thread[] decreThreads = new Thread[THREADS];
		
		for (int i = 0; i < THREADS; i++) {
			increThreads[i] = new Thread(incre);
			//decreThreads[i] = new Thread(decre);
			increThreads[i].start();
			//decreThreads[i].start();
		}
		
		for (int i = 0; i < THREADS; i++) {
			try {
				increThreads[i].join();
				//decreThreads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (int i = 0; i < atomic.length(); i++) {
			if (atomic.get(i) != 0) {
				System.out.println("atomic[" + i + "]:" + atomic.get(i));
			}
		}
		System.out.println("end of program.");
	}
}
