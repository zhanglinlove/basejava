package com.current.part06;

import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class Test2 {

	public static void main(String[] args) throws InterruptedException {
		LinkedBlockingDeque<String> list = new LinkedBlockingDeque<String>(3);
		Client client = new Client(list);
		Thread t = new Thread(client);
		t.start();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 3; j++) {
				String request = list.take();
				System.out.println(request + " at " + new Date() + " size:" + list.size());
			}
			TimeUnit.MILLISECONDS.sleep(300);
		}
		System.out.println("end of program.");
	}
}
