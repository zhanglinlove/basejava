package com.current.part08;

import java.util.Arrays;

public class ShellSort {

	public static void main(String[] args) {
		int[] arr = {9, 12, 34, 87, 46, 29, 19, -8, 55, 131};
		print(arr, "排序前");
		sort(arr);
		print(arr, "排序后");
	}
	
	public static void sort(int[] arr) {
		int j = 0;
		int temp;
		for (int i = arr.length/2; i > 0; i /=2) {
			for (int k = i; k < arr.length; k++) {
				temp = arr[k];
				for (j = k; j >= i; j -= i) {
					if (arr[j] < arr[j - i]) {
						arr[j] = arr[j - i];
					} else {
						break;
					}
				}
				arr[j] = temp;
			}
		}
	}
	
	public static void print(int[] arr, String msg) {
		System.out.println(msg + ":" + Arrays.toString(arr));
	}
}
