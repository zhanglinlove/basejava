package com.thread.part01;

public class Test1 {

	public static void main(String[] args) {
		MyThread1 t = new MyThread1();
		System.out.println("begin =" + System.currentTimeMillis());
		t.start();
		System.out.println("end =" + System.currentTimeMillis());
	}
}
