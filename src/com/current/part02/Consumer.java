package com.current.part02;

public class Consumer implements Runnable{

	private EventStorage eventStorage;
	
	public Consumer(EventStorage eventStorage) {
		this.eventStorage = eventStorage;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			eventStorage.get();
		}
	}

}
