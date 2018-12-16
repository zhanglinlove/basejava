package com.current.part08;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = {-12, 6, 22, 43, 23, 8, 12, -9, 101};
		print(arr, "排序前");
		sort(arr, 0, arr.length - 1);
		print(arr, "排序后");
	}
	
	public static void sort(int[] arr, int low, int high) {
		int mid = arr[(low + high) / 2];
		int left = low;
		int right = high;
		while (left < right) {
			while (arr[right] > mid) {
				right--;
			}
			while (arr[left] < mid) {
				left++;
			}
			if (left < right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
		}
		if (left == right) {
			left++;
		}
		if (left < high) {
			sort(arr, right + 1, high);
		}
		if (right > low) {
			sort(arr, low, left - 1);
		}
	}
	
	public static void print(int[] arr, String msg) {
		System.out.println(msg + ":" + Arrays.toString(arr));
	}
}
