package com.thread.part04;

public class ThreadD extends Thread{

	private MyService3 service;
	public ThreadD(MyService3 service) {
		this.service = service;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		service.awaitB();
	}
	
}
