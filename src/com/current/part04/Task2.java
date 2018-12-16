package com.current.part04;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Task2 implements Callable<Result>{

	private String name;
	
	public Task2(String name) {
		this.name = name;
	}
	@Override
	public Result call() throws Exception {
		System.out.println("name=" + name);
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			
		}
		int value = 0;
		for (int i = 0; i < 5; i++) {
			value += (int) (Math.random() * 100);
		}
		Result r = new Result();
		r.setName(name);
		r.setValue(value);
		return r;
	}

}
