package com.current.part06;

public class Test5 {

	public static void main(String[] args) {
		Thread[] threads = new Thread[3];
		for (int i = 0; i < threads.length; i++) {
			TaskLocalRandom task = new TaskLocalRandom();
			threads[i] = new Thread(task);
			threads[i].start();
		}
	}
}
