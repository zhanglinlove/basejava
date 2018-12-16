package com.thread.part03;

public class Product implements Runnable{

	private Storage storage;
	private Object lock;
	public Product(Storage storage, Object lock) {
		this.storage = storage;
		this.lock = lock;
	}
	
	public void run() {
		try {
			while (true) {
				Thread.sleep(2000);
				synchronized (lock) {
					while (storage.size() == storage.MAX_SIZE) {
						System.out.println("货物已经满了。");
						lock.wait();
					}
					storage.add();
					lock.notifyAll();
					System.out.println("生产者：" + Thread.currentThread().getName()
								+ ";当前货物数量：" + storage.size());
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
