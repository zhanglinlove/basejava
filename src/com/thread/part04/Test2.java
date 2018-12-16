package com.thread.part04;

public class Test2 {

	public static void main(String[] args) {
		MyService2 service = new MyService2();
		Thread t1 = new ThreadB(service);
		t1.start();
	}
}
