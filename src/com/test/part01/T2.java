package com.test.part01;

import java.util.Arrays;

public class T2 {

	public static void main(String[] args) {
		int[] arr = {21, 33, 24, 54, 39, 101, -9, 25, 77};
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void sort(int[] arr) {
		int len = arr.length;
		for (int i = 1; i < len; i++) {
			int key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}
	}
}
