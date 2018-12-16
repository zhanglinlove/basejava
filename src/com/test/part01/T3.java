package com.test.part01;

import java.util.Arrays;

public class T3 {

	public static void main(String[] args) {
		int[] arr = {21, 33, 24, 54, 39, 101, -9, 25, 77};
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void sort(int[] arr) {
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			int t = i;
			for (int j = i + 1; j < len; j++) {
				if (arr[j] < arr[t])
					t = j;
			}
			if (t != i) {
				int temp = arr[t];
				arr[t] = arr[i];
				arr[i] = temp;
			}
		}
	}
}
