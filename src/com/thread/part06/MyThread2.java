package com.thread.part06;

public class MyThread2 extends Thread{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println(Singleton.getInstance().hashCode());
	}

}
