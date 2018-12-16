package com.sheji.single;

public class Test1 {

	public static void main(String[] args) {
		Singleton1 s = Singleton1.getInstance();
		System.out.println(s.hashCode());
		Singleton1 s2 = Singleton1.getInstance();
		System.out.println(s2.hashCode());
	}
}
