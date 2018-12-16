package com.thread.part06;

public class Thread3 extends Thread{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println(SomeThing.INSTANCE.getInstance());
	}

}
