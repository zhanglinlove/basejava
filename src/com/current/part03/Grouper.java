package com.current.part03;

public class Grouper implements Runnable{

	private Results results;
	
	public Grouper(Results results) {
		this.results = results;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int finalResult = 0;
		System.out.println("grouper process result...");
		int data[] = results.getData();
		for (int number : data) {
			finalResult += number;
		}
		System.out.println("total result:" + finalResult);
	}

}
