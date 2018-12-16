package com.jvm.part01;

public class TestStackDeep {

	private static int count = 0;
	public static void main(String[] args) {
		try {
			recursion();
			recursion(1, 2, 3);
		} catch (Throwable e) {
			System.out.println("deep of call:" + count);
			e.printStackTrace();
		}
	}
	
	private static void recursion() {
		count++;
		recursion();
	}
	
	private static void recursion(long a, long b, long c) {
		long e = 1, f = 2, g = 3, h = 4, i = 5, k = 6, q =7, x = 8, y = 9, z = 10;
		count++;
		int j = 2;
		System.out.println(j);
		recursion(a, b, c);
	}
}
