package com.thread.part02;

public class Test3 {

	public static void main(String[] args) {
		MyThread t1 = new MyThread();
		
		ThreadC c = new ThreadC(t1);
		ThreadD d = new ThreadD(t1);
		
		c.start();
		d.start();
	}
}
