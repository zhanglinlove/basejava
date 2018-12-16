package com.thread.part01;

import java.util.concurrent.TimeUnit;

public class Test4 {

	public static void main(String[] args) {
		MyThread4 my = new MyThread4();
		ThreadA ta = new ThreadA(my);
		ThreadB tb = new ThreadB(my);
		Thread t1 = new Thread(ta);
		Thread t2 = new Thread(tb);
		t1.start();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();
	}

}
