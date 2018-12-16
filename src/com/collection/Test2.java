package com.collection;

public class Test2 {

	public static void main(String[] args) {
		int[] arr = {};
		int[] b = arr;
		b[0] = 1;
		if (b == arr) {
			System.out.println("---------");
		} else {
			System.out.println("========");
		}
	}
}
