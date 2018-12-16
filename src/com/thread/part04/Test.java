package com.thread.part04;

public class Test {

	public static void main(String[] args) {
		MyService service = new MyService();
		Thread a1 = new ThreadA(service);
		Thread a2 = new ThreadA(service);
		Thread a3 = new ThreadA(service);
		Thread a4 = new ThreadA(service);
		a1.start();
		a2.start();
		a3.start();
		a4.start();
	}
}
