package com.thread.part02;

public class MyThread {

	public void getInfo() {
		synchronized (this) {
			System.out.println(Thread.currentThread()+ ";" + System.currentTimeMillis());
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void getInfo2() {
		synchronized (this) {
			System.out.println(Thread.currentThread()+ ";" + System.currentTimeMillis());
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
