package com.search;
/**
 * 二分查找。
 * @author zhanglin
 *
 */
public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = {-1, 7, 13, 33, 45, 68, 98, 111};
		int index = search(arr, 44);
		System.out.println("索引："+index);
	}
	
	public static int search(int[] arr, int value) {
		int left = 0;
		int right = arr.length;
		while (left < right) {
			int mid = (left + right) / 2;
			if (arr[mid] == value) {
				return mid;
			} else if (arr[mid] < value) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}
}
