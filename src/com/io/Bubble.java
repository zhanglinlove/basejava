package com.io;

import java.util.Arrays;

public class Bubble {

	public static void main(String[] args) {
		int[] arr = {13, 24, 33, 57, -9, 8, 11, 98, 321, -97, 46};
		Bubble b = new Bubble();
		b.sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public void sort(int[] arr) {
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			for (int j = 1; j < len - i; j++) {
				if (arr[j] < arr[j - 1]) {
					int temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
}
