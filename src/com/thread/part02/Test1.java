package com.thread.part02;

public class Test1 {

	public static void main(String[] args) {
		HasNum n = new HasNum();
		Thread t1 = new ThreadA(n);
		Thread t2 = new ThreadB();
		t1.start();
		t2.start();
	}
}
