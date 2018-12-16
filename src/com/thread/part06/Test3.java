package com.thread.part06;

public class Test3 {

	public static void main(String[] args) {
		Thread t1 = new Thread3();
		Thread t2 = new Thread3();
		Thread t3 = new Thread3();
		Thread t4 = new Thread3();
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
