package com.current.part04;

import java.util.Date;
import java.util.concurrent.Callable;

public class Task5 implements Callable<String>, Runnable{

	private String name;
	
	public Task5(String name) {
		this.name = name;
	}
	
	@Override
	public String call() throws Exception {
		System.out.println(name + " start at " + new Date());
		return "hello, world";
	}

	@Override
	public void run() {
		System.out.println(System.currentTimeMillis());
	}

}
