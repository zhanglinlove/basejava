package com.current.part04;

import java.util.concurrent.TimeUnit;

public class Task8 implements Runnable{

	private String name;
	
	public Task8(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("task " + name + " start");
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("task " + name + " end.");
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}

}
