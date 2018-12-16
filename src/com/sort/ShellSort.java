package com.sort;

import java.util.Arrays;

/**
 * shell排序
 * @author zhanglin
 *
 */
public class ShellSort {

	public static void main(String[] args) {
		int[] arr = {43, 10, -4, 24, 44, 39, 87, 102};
		print(arr, "排序前");
		sort(arr);
	}
	
	public static void sort(int[] arr) {
		int k = 0;
		int max = 0;
		for (int i = arr.length / 2; i > 0; i/=2) {
			for (int j = i; j < arr.length; j++) {
				max = arr[j];
				for (k = j; k >= i; k-=i) {
					if (max < arr[k - i]) {
						arr[k] = arr[k - i];
					}else {
						break;
					}
				}
				arr[k] = max;
			}
			
		}
		print(arr, "排序后");
	}
	
	public static void print(int[] arr, String msg) {
		System.out.println(msg + ":" + Arrays.toString(arr));
	}
}
