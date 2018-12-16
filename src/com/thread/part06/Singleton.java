package com.thread.part06;

public class Singleton {

	private Singleton(){}
	
	public static Singleton getInstance() {
		return Inner.instance;
	}
	
	private static class Inner {
		private static Singleton instance = new Singleton();
	}
}
