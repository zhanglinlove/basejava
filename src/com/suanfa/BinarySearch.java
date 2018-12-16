package com.suanfa;

public class BinarySearch {

	/**
	 * 循环进行二分查找有序数组。
	 * @param arr		要查找的数组
	 * @param value		查找的值
	 * @return			返回序号
	 */
	public static int binarySearch(int[] arr, int value) {
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (value == arr[mid]) {
				return mid;
			} else if (value < arr[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}
	
	public static int binarySearch(int[] arr, int value, int low, int high) {
		int mid = (low + high) / 2;
		if (value == arr[mid]) {
			return mid;
		} else if (value < arr[mid]) {
			return binarySearch(arr, value, low, mid - 1);
		} else {
			return binarySearch(arr, value, mid + 1, high);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {-1, 7, 13, 22, 38, 40, 55, 62, 111};
		System.out.println("循环查找：" + binarySearch(arr, 13));
		System.out.println("递归查找：" + binarySearch(arr, 55, 0, arr.length - 1));
	}
}
