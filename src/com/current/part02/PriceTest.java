package com.current.part02;

public class PriceTest {

	public static void main(String[] args) {
		PriceInfo info = new PriceInfo();
		Reader reads[] = new Reader[5];
		Thread threadsRead[] = new Thread[5];
		for (int i = 0; i < 5; i++) {
			reads[i] = new Reader(info);
			threadsRead[i] = new Thread(reads[i]);
		}
		Writer w = new Writer(info);
		Thread writeThread = new Thread(w);
		
		for (int i = 0; i < 5; i++) {
			threadsRead[i].start();
		}
		writeThread.start();
	}
}
