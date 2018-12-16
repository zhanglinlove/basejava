package com.part01;

import java.util.Arrays;

public class Test6 {

	public static void main(String[] args) {
		int[] arr = {13, 44, 24, 98, 104, 97, -1, 76, 54};
		sort2(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	/**
	 * 时间复杂度:O(nlogn)
	 * 空间复杂度：O(1)
	 * @param arr
	 * @param low
	 * @param high
	 */
	public static void sort2(int[] arr, int low, int high) {
		int len = arr.length;
		for (int i = 1; i < len; i *= 2) {
			for (int j = 0; j < len - i; j += i * 2) {
				merge(arr, j, j + i - 1, Math.min(j + 2 * i - 1, len - 1));
			}
		}
	}
	
	/**
	 * 时间复杂度:O(nlogn)
	 * 空间复杂度:O(logn)
	 * @param arr
	 * @param low
	 * @param high
	 */
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
