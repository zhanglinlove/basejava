package com.suanfa;
/**
 * 插入排序。
 * @author zhanglin
 *
 */
public class InsertTest {

	public static void main(String[] args) {
		int[] arr = {1,32,23,12,9,45,28};
		print(arr);
		sort(arr);
	}
	
	public static void sort(int[] arr) {
		int len = arr.length;
		for (int i = 1; i < len; i++) {
			int j;
			int temp = arr[i];
			for (j = i; j > 0; j--) {
				if (arr[j - 1] > temp) {
					arr[j] = arr[j - 1];
				} else {
					break;
				}
			}
			arr[j] = temp;
		}
		print(arr);
	}
	
	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "  ");
		}
		System.out.println();
	}
}
