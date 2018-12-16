package com.basicmath;

import java.text.DecimalFormat;

/**
 * 判断101-200之间有多少个素数，并输出所有素数
 * 判断素数的方法：用一个数分别去除2到sqrt(这个数)，如果能被整除，
 * 则表明此数不是素数，反之是素数
 * @author zhanglin
 *
 * @date 2018年5月27日
 */
public class Prime {

	public static void main(String[] args) {
		Prime p = new Prime();
		for (int i = 100; i <= 200; i++) {
			if (p.isPrime(i)) {
				System.out.println(i + "是素数.");
			}
		}
	}
	
	public boolean isPrime(int num) {
		
		if (num < 3) return false;
		double a = Math.sqrt(num);
		int b = Integer.valueOf(new DecimalFormat("0").format(a));
		for (int i = 2; i <= b; i++) {
			if (num % i == 0) return false;
		}
		return true;
	}
}
