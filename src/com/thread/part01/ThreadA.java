package com.thread.part01;

public class ThreadA implements Runnable{
	
	private MyThread4 myThread4;

	public ThreadA(MyThread4 myThread4) {
		this.myThread4 = myThread4;
	}
	
	@Override
	public void run() {
		myThread4.test1();
	}

}
