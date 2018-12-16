package com.suanfa;
/**
 * 九九乘法表。
 * @author zhanglin
 *
 */
public class Test2 {

	public static void main(String[] args) {
		printMath();
	}
	
	public static void printMath() {
		for (int i = 1 , j = 1; j <= 9; i++) {
			System.out.print(i + " * " + j + " = " + (i * j) + "\t");
			if (i == j) {
				i = 0;
				j++;
				System.out.println();
			}
		}
	}
}
