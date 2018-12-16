package com.sort;

import java.util.Arrays;

/**
 * 选择排序。
 * @author zhanglin
 *
 */
public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = {4, 1, 33, -10, 24, 54, 66, 70, 101, 32};
		print(arr, "排序前");
		sort(arr);
	}
	
	public static void sort(int[] arr) {
		int length = arr.length;
		for (int i = 0; i < length - 1; i++) {
			int t = i;
			for (int j = i + 1; j < length; j++) {
				if (arr[t] > arr[j]) {
					t = j;
				}
			}
			if (i != t) {
				int temp = arr[i];
				arr[i] = arr[t];
				arr[t] = temp;
			}
		}
		print(arr, "排序后");
	}
	
	public static void print(int[] arr, String msg) {
		System.out.println(msg + ":" + Arrays.toString(arr));
	}
}
