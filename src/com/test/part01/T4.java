package com.test.part01;

import java.util.Arrays;

public class T4 {

	public static void main(String[] args) {
		int[] arr = {21, 33, 24, 54, 39, 101, -9, 25, 77};
		sort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	public static void sort(int[] arr, int low, int high) {
		if (low < high) {
			exchange(arr, low, high);
			int left = low;
			int right = high;
			int key = arr[low];
			while (left < right) {
				while (left < right && arr[right] > key)
					right--;
				arr[left] = arr[right];
				while (left < right && arr[left] <= key)
					left++;
				arr[right] = arr[left];
			}
			arr[left] = key;
			sort(arr, low, left - 1);
			sort(arr, left + 1, high);
		}
	}
	
	public static void exchange(int[] arr, int low, int high) {
		int mid = (low + high) / 2;
		int temp;
		if (arr[low] > arr[high]) {
			temp = arr[low];
			arr[low] = arr[high];
			arr[high] = temp;
		}
		if (arr[mid] > arr[high]) {
			temp = arr[mid];
			arr[mid] = arr[high];
			arr[high] = temp;
		}
		if (arr[low] < arr[mid]) {
			temp = arr[low];
			arr[low] = arr[mid];
			arr[mid] = temp;
		}
	}
}
