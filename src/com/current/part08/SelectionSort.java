package com.current.part08;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = {9, 12, 34, 87, 46, 29, 19, -8, 55, 131};
		print(arr, "排序前");
		sort(arr);
		print(arr, "排序后");
	}
	
	public static void sort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int t = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[t]) {
					t = j;
				}
			}
			if (t != i) {
				int temp = arr[t];
				arr[t] = arr[i];
				arr[i] = temp;
			}
		}
	}
	
	public static void print(int[] arr, String msg) {
		System.out.println(msg + ":" + Arrays.toString(arr));
	}
}
