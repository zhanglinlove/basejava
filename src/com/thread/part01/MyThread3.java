package com.thread.part01;

import java.util.Random;

public class MyThread3 extends Thread{

	@Override
	public void run() {
		long startTime = System.currentTimeMillis();
		long result = 0;
		for (int i = 0; i < 50000; i++) {
			new Random().nextInt();
			result = result + i;
		}
		long endTime = System.currentTimeMillis();
		System.out.println("☆☆☆thread2 use time:" + (endTime - startTime));
	}

}
