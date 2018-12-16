package com.current.part02;

public class Producer implements Runnable{

	private EventStorage eventStorage;
	
	public Producer(EventStorage eventStorage) {
		this.eventStorage = eventStorage;
	}
	
	public void run() {
		for (int i = 0; i < 10; i++) {
			eventStorage.set();
		}
		
	}

}
