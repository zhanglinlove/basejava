package com.thread.part01;

import java.util.concurrent.TimeUnit;

public class MyThread4 {

	public synchronized void test1() {
		System.out.println("test1------");
		System.out.println(System.currentTimeMillis());
		try {
			TimeUnit.SECONDS.sleep(7);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(System.currentTimeMillis());
		System.out.println("------sleep stop----");
	}
	
	public synchronized static void test2() {
		System.out.println("test2");
	}
}
