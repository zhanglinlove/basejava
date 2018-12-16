package com.thread.part02;

public class HasNum {

	private int num = 0;
	
	synchronized public void add(String name) {
		try {
			if ("a".equals(name)) {
				num = 100;
				System.out.println("a set over.");
				Thread.sleep(2000);
			} else {
				num = 200;
				System.out.println("b set over.");
			}
			System.out.println(name + " ;num=" + num);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	synchronized static void get() {
		try {
			Thread.sleep(1000);
			System.out.println(Thread.currentThread() + ";get method");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
