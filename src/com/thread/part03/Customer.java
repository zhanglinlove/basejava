package com.thread.part03;

public class Customer implements Runnable{

	private Storage storage;
	private Object lock;
	
	public Customer(Storage storage, Object lock) {
		this.storage = storage;
		this.lock = lock;
	}
	
	public void run() {
		try {
			while (true) {
				Thread.sleep(2000);
				synchronized (lock) {
					while (storage.size() == 0) {
						System.out.println("货物已经空了。");
						lock.wait();
					}
					storage.remove();
					System.out.println("消费者消费了物品：" + Thread.currentThread().getName() 
								+ ";当前数量为：" + storage.size());
					lock.notifyAll();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
