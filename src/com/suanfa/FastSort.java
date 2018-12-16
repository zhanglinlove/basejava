package com.suanfa;
/**
 * 快速排序。
 * @author zhanglin
 *
 */
public class FastSort {

	public static void main(String[] args) {
		int[] arr = {23, 25, 11, -9, 39, 66, 97, 101, 49};
		System.out.println("排序前：");
		display(arr);
		partition(arr);
		System.out.println("排序后：");
		display(arr);
	}
	
	public static void partition(int[] arr) {
		sort(arr, 0, arr.length - 1);
	}
	
	public static void sort(int[] arr, int low, int high) {
		if (low >= high) {
			return;
		}
		int temp = arr[low];
		int start = low;
		int end = high;
		while (start < end) {
			while (start < end && arr[end] > temp) {
				end--;
			}
			arr[start] = arr[end];
			while (start < end && arr[start] < temp) {
				start++;
			}
			arr[end] = arr[start];
		}
		arr[end] = temp;
		sort(arr, low, end - 1);
		sort(arr, end + 1, high);
	}
	
	public static void display(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
}
