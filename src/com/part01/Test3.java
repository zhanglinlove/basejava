package com.part01;

import java.util.Arrays;

public class Test3 {

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
		for (int i = 0; i < len; i++) {
			int t = i;
			for (int j = i + 1; j < len; j++) {
				if (arr[j] < arr[t]) 
					t = j;
			}
			if (t != i) {
				int temp = arr[t];
				arr[t] = arr[i];
				arr[i] = temp;
			}
		}
	}
}
