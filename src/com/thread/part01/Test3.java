package com.thread.part01;

public class Test3 {

	public static void main(String[] args) {
		Thread t1 = new MyThread2();
		Thread t2 = new MyThread3();
		t1.setPriority(3);
		t1.start();
		t2.setPriority(10);
		t2.start();
	}
}
