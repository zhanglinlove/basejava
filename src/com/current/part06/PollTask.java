package com.current.part06;

import java.util.concurrent.ConcurrentLinkedDeque;

public class PollTask implements Runnable{

	private ConcurrentLinkedDeque<String> list;
	
	public PollTask(ConcurrentLinkedDeque<String> list) {
		this.list = list;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 500; i++) {
			list.pollFirst();
			list.pollLast();
		}
	}

}
