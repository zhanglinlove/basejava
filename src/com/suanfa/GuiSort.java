package com.suanfa;

import java.util.Arrays;

/**
 * 归并排序。
 * @author zhanglin
 * 时间复杂度：
 * T[n]=2T[n/2] + 2n
 *2T[n/2] = 2T[n/4] + n=4T[n/4] + 4n
 *2^m-1T[n/2^m-1]=2^mT[1]+mn
 *T[n/2^m]=T[1]
 *n/2^m=1 ====> 2^m = n ======> m = logn
 *T[n]=n+nlogn
 *空间复杂度：
 *那个临时的数组和递归时压入栈的数据占用的空间：n + logn；
 *所以空间复杂度为: O(n)
 */
public class GuiSort {

	public static void main(String[] args) {
		int[] arr = {13,-10,9,32,14,76,92,32};
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void sort(int[] arr) {
		merge(arr, 0, arr.length - 1);
		
	}
	
	public static int[] merge(int[] arr, int left, int right) {
		
		int mid = (left + right) / 2;
		if (left < right) {
			merge(arr, left, mid);
			merge(arr, mid + 1, right);
			mergeSort(arr, left, mid, right);
		}
		return arr;
	}
	
	public static void mergeSort(int[] arr, int low, int mid, int high) {
		int[] temp = new int[high - low + 1];
		int i = low;
		int j = mid + 1;
		int k = 0;
		while (i <= mid && j <= high) {
			if (arr[i] > arr[j]) {
				temp[k++] = arr[j++];
			} else {
				temp[k++] = arr[i++];
			}
		}
		while (i <= mid) {
			temp[k++] = arr[i++];
		}
		while (j <= high) {
			temp[k++] = arr[j++];
		}
		for (int k2 = 0; k2 < temp.length; k2++) {
			arr[k2 + low] = temp[k2];
		}
	}
}
