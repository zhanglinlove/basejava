package com.sort;

import java.util.Arrays;

/**
 * 快速排序
 * @author zhanglin
 *
 */
public class QuickSort {

	public static void main(String[] args) {
		int[] arr = {9, -10, 22, 34, 56, 72, 8, 24, -1};
		print(arr, "排序前");
		sort(arr, 0, arr.length - 1);
		print(arr, "排序后");
	}
	
	public static void sort(int[] arr, int low, int high) {
		int lleft = low;
		int lright = high;
		int t;
		int mid = arr[(lleft + lright) / 2];
		while (lleft < lright) {
			while (mid < arr[lright]) {
				lright--;
			}
			while (mid > arr[lleft]) {
				lleft++;
			}
			if (lleft < lright) {
				t = arr[lleft];
				arr[lleft] = arr[lright];
				arr[lright] = t;
				--lright;
				++lleft;
			}
		}
		if (lleft == lright) {
			lleft++;
		}
		if (lleft < high) {
			sort(arr, lright + 1, high);
		}
		if (low < lright) {
			sort(arr, low, lleft - 1);
		}
	}
	
	public static void print(int[] arr, String msg) {
		System.out.println(msg + ":" + Arrays.toString(arr));
	}
}
