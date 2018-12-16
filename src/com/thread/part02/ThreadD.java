package com.thread.part02;

public class ThreadD extends Thread {

	private MyThread thread;
	
	public ThreadD(MyThread thread) {
		this.thread = thread;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		for (int i = 0; i < 10; i++) {
			thread.getInfo2();
			
		}
		
	}
	
}
