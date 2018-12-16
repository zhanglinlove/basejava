package com.current.part01;

public class Test1 {

	public static void main(String[] args) {
		Calculator c = null;
		for (int i = 0; i <10; i++) {
			c = new Calculator(i);
			Thread t = new Thread(c);
			t.start();
		}
	}
}
