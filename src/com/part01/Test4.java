package com.part01;

import java.util.Arrays;

public class Test4 {

	public static void main(String[] args) {
		int[] arr = {13, 44, 24, 98, 104, 97, -1, 76, 54};
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	/**
	 * 时间复杂度:
	 * T(1) = O(1)
	 * T(n) = logn*( ) 
	 * @param arr
	 */
	public static void sort(int[] arr) {
		int len = arr.length;
		for (int i = len / 2; i > 0; i /= 2) {
			for (int j = i; j < len; j++) {
				int key = arr[j];
				int k = j;
				while (k >= i && arr[k - i] > key) {
					arr[k] = arr[k - i];
					k = k - i;
				}
				arr[k] = key;
			}
		}
	}
}
