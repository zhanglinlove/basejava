package com.thread.part04;

public class Test3 {

	public static void main(String[] args) {
		MyService2 service = new MyService2();
		Thread t = new ThreadB(service);
		t.start();
		try {
			Thread.sleep(2000);
			service.signal();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
