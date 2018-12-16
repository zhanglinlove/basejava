package com.thread.part04;

public class ThreadB extends Thread{

	private MyService2 myService2;
	public ThreadB(MyService2 myService2) {
		this.myService2 = myService2;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		myService2.await();
	}
	
}
