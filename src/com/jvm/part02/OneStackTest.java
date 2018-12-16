package com.jvm.part02;

public class OneStackTest {

	public static class User {
		public int id = 0;
		public String name = "";
	}
	
	public static void alloc() {
		User u = new User();
		u.id = 15;
		u.name = "geym";
	}
	
	public static void main(String[] args) {
		long b = System.currentTimeMillis();
		for (int i = 0; i < 100000000; i++) {
			alloc();
		}
		long e = System.currentTimeMillis();
		System.out.println(e - b);
	}
}
