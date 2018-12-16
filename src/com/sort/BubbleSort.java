package com.sort;

import java.util.Arrays;

/**
 * 冒泡排序.
 * @author zhanglin
 *
 */
public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = {-12, 6, 22, 43, 23, 8, 12, -9, 101};
		print(arr, "排序前");
		sort(arr);
	}
	
	public static void sort(int[] arr) {
		int length = arr.length;
		for (int i = 1; i < length; i++) {
			for (int j = 0; j < length -  i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		print(arr, "排序后");
	}
	
	public static void print(int[] arr, String msg) {
		System.out.println(msg + ":" + Arrays.toString(arr));
	}
}
