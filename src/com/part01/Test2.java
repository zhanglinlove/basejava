package com.part01;

import java.util.Arrays;

public class Test2 {

	public static void main(String[] args) {
		int[] arr = {13, 44, 24, 98, 104, 97, -1, 76, 54};
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	/**
	 * 时间复杂度:O(n2)
	 * 空间复杂度:O(1)
	 * @param arr
	 */
	public static void sort(int[] arr) {
		int len = arr.length;
		for (int i = 1; i < len; i++) {
			int key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > key) {
				if (arr[j] > key) {
					arr[j + 1] = arr[j];
					j--;
				} else {
					break;
				}
			}
			arr[j + 1] = key;
		}
	}
}
