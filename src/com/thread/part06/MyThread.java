package com.thread.part06;

public class MyThread extends Thread{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println(MyObject.getInstance().hashCode());
	}

}
