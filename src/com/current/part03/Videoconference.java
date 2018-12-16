package com.current.part03;

import java.util.concurrent.CountDownLatch;

public class Videoconference implements Runnable{

	private final CountDownLatch controller;
	
	public Videoconference(int number) {
		controller = new CountDownLatch(number);
	}
	
	public void arrive(String name) {
		System.out.println(name + " has arrive.");
		controller.countDown();
		System.out.println("videoconference waiting for:" + controller.getCount());
	}
	
	@Override
	public void run() {
		System.out.println("videoconference count:" + controller.getCount());
		try {
			controller.await();
			System.out.println("videoconference : all people has arrive.");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
