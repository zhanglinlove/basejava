package com.sort;

import java.util.Arrays;

/**
 * 插入算法。
 * @author zhanglin
 *
 */
public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = {-34, 23, 6, 14, 22, 56, 78, 89, 143, 111};
		print(arr, "排序前");
		sort(arr);
	}
	
	public static void sort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int t = arr[i];
			int j = i -1;
			while (j >= 0 && t < arr[j]) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = t;
		}
		print(arr, "排序后");
	}
	
	public static void print(int[] arr, String msg) {
		System.out.println(msg + ":" + Arrays.toString(arr));
	}
}
