package com.thread.part02;

public class ThreadC extends Thread{

	private MyThread thread;
	
	public ThreadC(MyThread thread) {
		this.thread = thread;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		for (int i = 0; i < 10; i++) {
			thread.getInfo();
			
		}
	}
	
}
