package com.test.part01;

import java.util.Arrays;

public class T5 {

	public static void main(String[] args) {
		int[] arr = {21, 33, 24, 54, 39, 101, -9, 25, 77};
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void sort(int[] arr) {
		int len = arr.length;
		for (int i = len / 2; i > 0; i /= 2) {
			for (int j = i; j < len; j++) {
				int key = arr[j];
				int k = j;
				while (k >= i && arr[k - i] > key) {
					arr[k] = arr[k - i];
					k = k - i;
				}
				arr[k] = key;
			}
		}
	}
}
