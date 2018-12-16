package com.current.part08;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = {9, 12, 34, 87, 46, 29, 19, -8, 55, 131};
		print(arr, "排序前");
		sort(arr);
		print(arr, "排序后");
	}
	
	public static void sort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length -i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}
	
	public static void print(int[] arr, String msg) {
		System.out.println(msg + ":" + Arrays.toString(arr));
	}
}
