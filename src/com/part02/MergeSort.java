package com.part02;

public class MergeSort {

	/**
	 * 归并
	 * @param data
	 * @param left
	 * @param center
	 * @param right
	 */
	public static void merge(int[] data, int left, int center, int right) {
		int[] tmpArr = new int[data.length];
		int mid = center + 1;
		int tmp = left;
		int third = left;
		while (left <= center && mid <= right) {
			if (data[left] <= data[mid]) {
				tmpArr[third++] = data[left++];
			} else {
				tmpArr[third++] = data[mid++];
			}
		}
		while (mid <= right) {
			tmpArr[third++] = data[mid++];
		}
		while (left <= center) {
			tmpArr[third++] = data[left++];
		}
		while (tmp <= right) {
			data[tmp] = tmpArr[tmp++];
		}
	}
	
	public static void sort(int[] data, int left, int right) {
		if (left >= right) {
			return;
		}
		int center = (left + right) / 2;
		sort(data, left, center);
		sort(data, center + 1, right);
		merge(data, left, center, right);
	}
	
	public static void print(int[] data) {
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + "\t");
		}
		System.out.println();
	}
	
	public static void mergeSort(int[] data) {
		sort(data, 0, data.length - 1);
	}
	
	public static void main(String[] args) {
		int[] a = {32,-5,67,17,9,78,46,982,356,76,29};
		print(a);
		System.out.println("排序后的顺序：");
		mergeSort(a);
		print(a);
	}
}
