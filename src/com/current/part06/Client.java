package com.current.part06;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class Client implements Runnable{

	private LinkedBlockingDeque<String> resultList;
	
	public Client(LinkedBlockingDeque<String> resultList) {
		this.resultList = resultList;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 3; j++) {
				StringBuilder builder = new StringBuilder();
				builder.append(i);
				builder.append(":");
				builder.append(j);
				resultList.push(builder.toString());
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		System.out.println("Client: end.");
	}

}
