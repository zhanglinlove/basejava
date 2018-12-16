package com.part01;

import java.util.Arrays;

public class Test1 {

	public static void main(String[] args) {
		int[] arr = {13, 44, 24, 98, 104, 97, -1, 76, 54};
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	/**
	 * 时间复杂度：
	 * (n - 1) + (n - 2) + (n - 3) + ... + 2 + 1
	 * n*n/2=O(n2)
	 * 空间复杂度：辅助空间变量O(1)
	 * @param arr
	 */
	public static void sort(int[] arr) {
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}
}
