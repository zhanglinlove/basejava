package com.thread.part02;

public class ThreadB extends Thread{

	//private HasNum hasNum;
	public ThreadB() {
		//this.hasNum = hasNum;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		HasNum.get();
	}
	
}
