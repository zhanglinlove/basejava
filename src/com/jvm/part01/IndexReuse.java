package com.jvm.part01;

public class IndexReuse {

	public static void method1() {
		int a = 0;
		System.out.println(a);
		int b = 0;
	}

	public static void method2() {
		{
			int a = 0;
			System.out.println(a);
		}
		int b = 0;
	}

	public static void main(String[] args) {

	}
}
