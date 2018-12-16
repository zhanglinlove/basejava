package com.thread.part06;

public class Test2 {

	public static void main(String[] args) {
		Thread t1 = new MyThread2();
		Thread t2 = new MyThread2();
		Thread t3 = new MyThread2();
		Thread t4 = new MyThread2();
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
