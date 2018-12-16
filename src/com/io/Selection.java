package com.io;

import java.util.Arrays;

public class Selection {

	public static void main(String[] args) {
		int[] arr = {13, 24, 33, 57, -9, 8, 11, 98, 321, -97, 46};
		Selection s = new Selection();
		s.sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public void sort(int[] arr) {
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			int t = i;
			for (int j = i + 1; j < len; j++) {
				if (arr[j] < arr[t]) {
					t = j;
				}
			}
			if (t != i) {
				int temp = arr[i];
				arr[i] = arr[t];
				arr[t] = temp;
			}
		}
	}
}
