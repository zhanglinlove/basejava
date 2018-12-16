package com.gaoji;

import java.util.Arrays;
/**
 * 选择排序。
 * @author zhanglin
 *
 */
public class SelectSort {

	private long[] a;
	private int nElements;
	
	public SelectSort(int max) {
		a = new long[max];
		nElements = 0;
	}
	
	public void insert(long value) {
		if (nElements > a.length) {
			throw new IndexOutOfBoundsException("索引超出了最大值。");
		}
		a[nElements++] = value;
	}
	
	public void display() {
		System.out.println(Arrays.toString(a));
	}
	
	public void selectSort() {
		int min;
		for (int i = 0; i < a.length - 1; i++) {
			min = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[min]) {
					min = j;
				}
			}
			long temp = a[i];
			a[i] = a[min];
			a[min] = temp;
		}
	}
	
	public static void main(String[] args) {
		int maxSize = 20;
		SelectSort sort = new SelectSort(maxSize);
		sort.insert(-1);
		sort.insert(12);
		sort.insert(23);
		sort.insert(41);
		sort.insert(70);
		sort.insert(29);
		sort.insert(33);
		sort.display();
		System.out.println("------------------------------");
		sort.selectSort();
		sort.display();
	}
}
