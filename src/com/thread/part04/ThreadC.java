package com.thread.part04;

public class ThreadC extends Thread{

	private MyService3 service;
	public ThreadC(MyService3 service) {
		this.service = service;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		service.await();
	}
	
}
