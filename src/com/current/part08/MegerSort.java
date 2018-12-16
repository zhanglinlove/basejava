package com.current.part08;

import java.util.Arrays;

public class MegerSort {

	public static void main(String[] args) {
		int[] arr = {9, 12, 34, 87, 46, 29, 19, -8, 55, 131};
		print(arr, "排序前");
		sort(arr, 0, arr.length - 1);
		print(arr, "排序后");
	}
	
	public static void sort(int[] arr, int low, int high) {
		int mid = (low + high) / 2;
		if (low < high) {
			sort(arr, low, mid);
			sort(arr, mid + 1, high);
			meger(arr, low, mid, high);
		}
	}
	
	public static void meger(int[] arr, int low, int mid, int high) {
		int[] temp = new int[high - low + 1];
		int left = low;
		int right = mid + 1;
		int j = 0;
		while (left <= mid && right <= high) {
			if (arr[left] < arr[right]) {
				temp[j++] = arr[left++];
			} else {
				temp[j++] = arr[right++];
			}
		}
		while (left <= mid) {
			temp[j++] = arr[left++];
		}
		while (right <= high) {
			temp[j++] = arr[right++];
		}
		for (int i = 0; i < temp.length; i++) {
			arr[low + i] = temp[i];
		}
	}
	
	public static void print(int[] arr, String msg) {
		System.out.println(msg + ":" + Arrays.toString(arr));
	}
}
