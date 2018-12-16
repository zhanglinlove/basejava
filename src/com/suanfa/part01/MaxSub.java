package com.suanfa.part01;

public class MaxSub {

	public static void main(String[] args) {
		int[] arr = {3, 1, -5, 14};
		int max = maxLengthSub(arr);
		System.out.println("最大子序列值:" + max);
	}
	
	public static int maxLengthSub(int[] arr) {
		if (arr == null || arr.length == 0)
			return 0;
		int max = 0;
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (sum > max) {
				max = sum;
			}
			if (sum < 0) {
				sum = 0;
			}
		}
		return max;
	}
}
