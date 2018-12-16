package com.sort;

import java.util.Arrays;
/**
 * 合并排序。
 * @author zhanglin
 *
 */
public class MergeSort {

	public static void main(String[] args) {
		int[] arr = {90, 32, 1, 39, 12, -9, 56, 98, 143, 34, 86, 59, 39};
		print(arr, "排序前");
		sort(arr, 0, arr.length - 1);
		print(arr, "排序后");
	}
	
	public static void sort(int[] arr, int low, int high) {
		int mid = (low + high) / 2;
		if (low < high) {
			sort(arr, low, mid);
			sort(arr, mid + 1, high);
			merge(arr, low, mid, high);
		}
	}
	
	public static void merge(int[] arr, int low, int mid, int high) {
		int temp[] = new int[high - low + 1];
		int left = low;
		int rIndex = 0;
		int m = mid + 1;
		while (left <= mid && m <= high) {
			if (arr[left] < arr[m]) {
				temp[rIndex++] = arr[left++];
			} else {
				temp[rIndex++] = arr[m++];
			}
		}
		while (left <= mid) {
			temp[rIndex++] = arr[left++];
		}
		while (m <= high) {
			temp[rIndex++] = arr[m++];
		}
		
		for (int i = 0; i < temp.length; i++) {
			arr[low + i] = temp[i];
		}
		
	}
	
	public static void print(int[] arr, String msg) {
		System.out.println(msg + ":" + Arrays.toString(arr));
	}
}
