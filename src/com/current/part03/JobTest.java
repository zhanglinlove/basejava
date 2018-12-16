package com.current.part03;

public class JobTest {

	public static void main(String[] args) {
		PrintQueue queue = new PrintQueue();
		
		Thread thread[] = new Thread[10];
		for (int i = 0; i < 10; i++) {
			thread[i] = new Thread(new Job(queue), "Thread-" + i);
		}
		
		for (int i = 0; i < 10; i++) {
			thread[i].start();
		}
	}
}
