package com.current.part04;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Task implements Runnable{

	private Date initDate;
	private String name;
	
	public Task(String name) {
		this.initDate = new Date();
		this.name = name;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + 
				" :task " + name + " created on " + initDate);
		try {
			System.out.println(Thread.currentThread().getName() + ":task "
					  	+ name);
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
			
		}
		System.out.println(Thread.currentThread().getName() + ":task "
			  	+ name + " finished.");
	}

}
