package com.current.part04;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Task7 implements Callable<String>{

	
	@Override
	public String call() throws Exception {
		while (true) {
			System.out.println("task start.");
			TimeUnit.SECONDS.sleep(1);
		}
		
	}

}
