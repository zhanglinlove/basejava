package com.test.part01;

import java.util.Arrays;

public class T6 {

	public static void main(String[] args) {
		int[] arr = {21, 33, 24, 54, 39, 101, -9, 25, 77};
		sort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	public static void sort(int[] arr, int low, int high) {
		if (low < high) {
			int mid = (low + high) / 2;
			sort(arr, low, mid);
			sort(arr, mid + 1, high);
			merge(arr, low, mid, high);
		}
	}
	
	public static void merge(int[] arr, int low, int mid, int high) {
		int[] temp = new int[high - low + 1];
		int left = low;
		int r = mid + 1;
		int k = 0;
		while (left <= mid && r <= high) {
			if (arr[left] < arr[r]) {
				temp[k++] = arr[left++];
			} else {
				temp[k++] = arr[r++];
			}
		}
		while (left <= mid)
			temp[k++] = arr[left++];
		while (r <= high)
			temp[k++] = arr[r++];
		for (int i = 0; i < temp.length; i++)
			arr[low + i] = temp[i];
	}
}
