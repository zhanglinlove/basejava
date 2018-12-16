package com.current.part04;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class ExecutableTask implements Callable<String>{

	private String name;
	
	public String getName() {
		return name;
	}

	public ExecutableTask(String name) {
		this.name = name;
	}
	
	@Override
	public String call() throws Exception {
		TimeUnit.SECONDS.sleep(2);
		return "hello, world. I'am " + name;
	}

}
