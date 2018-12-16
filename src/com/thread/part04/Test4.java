package com.thread.part04;

public class Test4 {

	public static void main(String[] args) {
		MyService3 service = new MyService3();
		Thread t1 = new ThreadC(service);
		Thread t2 = new ThreadD(service);
		t1.setName("A");
		t1.start();
		t2.setName("B");
		t2.start();
		try {
			Thread.sleep(2000);
			service.signal_all();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
