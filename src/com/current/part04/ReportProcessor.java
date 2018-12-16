package com.current.part04;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ReportProcessor implements Runnable{

	private CompletionService<String> service;
	private boolean end;
	
	public ReportProcessor(CompletionService<String> service) {
		this.service = service;
		end = false;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (!end) {
			try {
				Future<String> result = service.poll(20, TimeUnit.SECONDS);
				if (result != null) {
					String report = result.get();
					System.out.println("report receive " + report);
					
				}
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println("report end.");
	}

	public void setEnd(boolean end) {
		this.end = end;
	}

	
}
