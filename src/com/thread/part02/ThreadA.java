package com.thread.part02;

public class ThreadA extends Thread{

	private HasNum hasNum;
	public ThreadA(HasNum hasNum) {
		this.hasNum = hasNum;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		hasNum.add("a");
	}
	
}
