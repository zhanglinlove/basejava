package com.current.part01;

public class Test4 {

	public static void main(String[] args) {
		FileMock mock = new FileMock(100, 10);
		Buffer buffer = new Buffer(20);
		Producer p = new Producer(mock, buffer);
		Thread threadProducer = new Thread(p, "Producer");
		Consumer consumers[] = new Consumer[3];
		Thread threadConsumer[] = new Thread[3];
		for (int i = 0; i < 3; i++) {
			consumers[i] = new Consumer(buffer);
			threadConsumer[i] = new Thread(consumers[i], "Consumer" + i);
		}
		threadProducer.start();
		for (int i = 0; i < 3; i++) {
			threadConsumer[i].start();
		}
	}
}
