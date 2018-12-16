package com.jvm.part02;

public class Test {

	private Object instance;
	
	public Test() {
		byte[] b = new byte[10 * 1024 * 1024];
	}

	public static void main(String[] args) {
		Test t1 = new Test();
		Test t2 = new Test();
		
		t1.instance = t2;
		t2.instance = t1;
		
		t1 = null;
		t2 = null;
	}
}
