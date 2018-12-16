package com.current.part01;

public class Test3 {

	public static void main(String[] args) {
		Thread[] threads = new Thread[10];
		PrintQueue p = new PrintQueue();
		for (int i = 0; i < 10; i++) {
			threads[i] = new Thread(new MyThread(p));
		}
		for (int i = 0; i < 10; i++) {
			threads[i].start();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
