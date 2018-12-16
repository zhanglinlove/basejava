package com.jvm.part07;

public class MultiThreadOOM {

	public static class SleepThread  implements Runnable {

		@Override
		public void run() {
			try {
				Thread.sleep(10000000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 1500; i++) {
			new Thread(new SleepThread(), "Thread-" + i).start();
			System.out.println("Thread " + i + " created");
		}
	}
}
