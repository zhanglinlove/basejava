package com.current.part06;

import java.util.concurrent.ThreadLocalRandom;

public class TaskLocalRandom implements Runnable{

	public TaskLocalRandom() {
		ThreadLocalRandom.current();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String name = Thread.currentThread().getName();
		for (int i = 0; i < 10; i++) {
			System.out.println(name + ":" + ThreadLocalRandom.current().nextInt(10));
		}
	}

}
