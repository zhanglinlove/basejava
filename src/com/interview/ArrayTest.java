package com.interview;

public class ArrayTest {

	public static void main(String[] args) {
		int[] arr = new int[] {1,3,5,7,9};
		String[] str = new String[3];
		int[] newArr = new int[arr.length];
		System.arraycopy(arr, 0, newArr, 0, arr.length);
		arr[2] = 44;
		for (int i : newArr) {
			System.out.println(i);
		}
	}
}
