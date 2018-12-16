package com.suanfa.part01;

import java.util.Arrays;

public class Insertion {

	public static void main(String[] args) {
		int[] arr = {12, 23, 44, 56, 78, 101, -9, 34, 79};
		sort2(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void sort(int[] arr) {
		int length = arr.length;
		for (int i = 0, j = i; i < length - 1; j = ++i) {
			int ai = arr[i + 1];
			while (ai < arr[j]) {
				arr[j + 1] = arr[j];
				if (j-- == 0) {
					break;
				}
			}
			arr[j + 1] = ai;
		}
	}
	
	public static void sort2(int[] arr) {
		int length = arr.length;
		for (int i = 1; i < length; i++) {
			int k = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > k) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = k;
		}
	}
}
