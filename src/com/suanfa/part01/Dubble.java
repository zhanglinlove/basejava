package com.suanfa.part01;

import java.util.Arrays;

public class Dubble {

	public static void main(String[] args) {
		int[] arr = {12, 23, 44, 56, 78, 101, -9, 34, 79};
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void sort(int[] arr) {
		int length = arr.length;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}
}
