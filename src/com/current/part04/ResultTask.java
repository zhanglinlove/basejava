package com.current.part04;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ResultTask extends FutureTask<String>{

	private String name;
	
	public ResultTask(Callable<String> callable) {
		super(callable);
		this.name = ((ExecutableTask) callable).getName();
	}

	@Override
	protected void done() {
		if (this.isCancelled()) {
			System.out.println("has canceled.");
		} else {
			System.out.println("has finished..");
		}
	}

}
