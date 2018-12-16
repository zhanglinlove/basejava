package com.suanfa;
/**
 * 冒泡排序法。
 * @author zhanglin
 *
 */
public class MaoPaoSort {

	public static void main(String[] args) {
		int[] a = {-12,32,42,11,7,45,24,18,67,101};
		print(a, "排序前");
		sort(a);
	}
	
	public static void sort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length - i - 1; j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
		print(a, "排序后");
	}
	
	public static void print(int[] a, String name) {
		System.out.println("-----------" + name + "---------------");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "  ");
		}
		System.out.println();
	}
}
