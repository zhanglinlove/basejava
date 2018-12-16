package com.current.part04;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class ReportGenerator implements Callable<String>{

	private String sender;
	private String title;
	
	public ReportGenerator(String sender, String title) {
		this.sender = sender;
		this.title = title;
	}
	
	@Override
	public String call() throws Exception {
		TimeUnit.SECONDS.sleep(4);
		return sender + ":" + title;
	}

}
