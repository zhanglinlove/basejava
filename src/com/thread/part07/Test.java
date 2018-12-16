package com.thread.part07;

public class Test {

	public static void main(String[] args) {
		Thread t = new MyThread();
		System.out.println("main方法中的状态：" + t.getState());
		
		try {
			Thread.sleep(1000);
			t.start();
			Thread.sleep(1000);
			System.out.println("main方法中的状态2：" + t.getState());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
