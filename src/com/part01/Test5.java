package com.part01;

import java.util.Arrays;
import java.util.Stack;

public class Test5 {

	public static void main(String[] args) {
		int[] arr = {13, 44, 24, 98, 104, 97, -1, 76, 54};
		sort2(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	/**
	 * 时间复杂度:O(nlogn)
	 * 空间复杂度:O(1)
	 * @param arr
	 * @param low
	 * @param high
	 */
	public static void sort2(int[] arr, int low, int high) {
		if (arr == null || arr.length < 2) 
			return;
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		stack.push(arr.length - 1);
		int left, right;
		while (!stack.isEmpty()) {
			right = stack.pop();
			left = stack.pop();
			int f = p(arr, left, right);
			if (low < f - 1) {
				stack.push(low);
				stack.push(f - 1);
			}
			if (f + 1 < right) {
				stack.push(f + 1);
				stack.push(right);
			}
		}
	}
	
	private static int p(int[] arr, int low, int high) {
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
			return left;
		}
		return low;
	}
	
	/**
	 * 时间复杂度:T(1) = O(n)
	 * T(n) = 2T(n/2) + O(1) = 2*2T(n/4) + 2O(n)
	 * T(n/2) = 2T(n/4) + O(n)
	 * 
	 * 令n = 2*x  则x = logn
	 * T(1) = 2T(n/2*x) + O(n)
	 * 
	 * T(n) = nT(1) + lognO(n) = O(nlogn)
	 * 
	 * 空间复杂度：计算辅助空间
	 * O(logn)
	 * @param arr
	 * @param low
	 * @param high
	 */
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
