package com.current.part08;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = {9, 12, 34, 87, 46, 29, 19, -8, 55, 131};
		print(arr, "排序前");
		sort(arr);
		print(arr, "排序后");
	}
	
	public static void sort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int t = arr[i];
			int j = i - 1;
			while (j >= 0 && t < arr[j]) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = t;
		}
	}
	
	public static void print(int[] arr, String msg) {
		System.out.println(msg + ":" + Arrays.toString(arr));
	}
}
