package com.search;
/**
 * 顺序查找。
 * @author zhanglin
 *
 */
public class OrderSearch {

	public static void main(String[] args) {
		int[] arr = {10, 4, -9, 34, 87, 102, 93};
		int index = orderSearch(arr, 34);
		if (index > -1) {
			System.out.println("数字34的位置"+index);
		} else {
			System.out.println("没有这个数字。");
		}
	}
	
	public static int orderSearch(int[] arr, int value) {
		int f = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == value) {
				f = i;
				break;
			}
		}
		return f;
	}
}
