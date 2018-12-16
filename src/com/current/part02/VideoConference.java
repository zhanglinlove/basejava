package com.current.part02;

import java.util.concurrent.CountDownLatch;
/**
 * 等待完成了number数量，再触发.
 * @author zhanglin
 *
 */
public class VideoConference implements Runnable{

	private final CountDownLatch controller;
	
	public VideoConference(int number) {
		controller = new CountDownLatch(number);
	}
	
	public void arrive(String name) {
		System.out.printf("%s has arrive.\n", name);
		controller.countDown();
		System.out.println("vedioConference waiting for " + controller.getCount()
					+ " participants.\n");
	}
	
	public void run() {
		System.out.printf("VedioConference: Initialization: %d \n", controller.getCount());
		try {
			controller.await();
			System.out.println("all people has arrive.");
			System.out.println("Let's start...");
		} catch (InterruptedException e) {
			
		} 
	}

}
