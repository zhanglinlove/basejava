package com.thread.part02;

public class Test2 {

	public static void main(String[] args) {
		HasNum n = new HasNum();
		HasNum n2 = new HasNum();
		Thread t1 = new ThreadA(n);
		Thread t2 = new ThreadB();
		t1.start();
		t2.start();
	}
}
