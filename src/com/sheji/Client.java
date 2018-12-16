package com.sheji;

public class Client {

	public static void main(String[] args) {
		Computer c = new Computer();
		c.start();
		System.out.println("------------------");
		c.shutdown();
	}
}
