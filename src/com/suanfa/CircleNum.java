package com.suanfa;
/**
 * 回文数。
 * @author zhanglin
 *
 */
public class CircleNum {

	public static void main(String[] args) {
		for (int i = 10; i < 1000; i++) {
			getCircle(i);
		}
	}
	
	public static void getCircle(int num) {
		int oldValue = num;
		int temp = 0;
		while (num > 0) {
			temp = temp * 10 + num % 10;
			num = num / 10;
		}
		if (temp == oldValue) {
			System.out.println(oldValue + " is circle num.");
		}
	}
}
