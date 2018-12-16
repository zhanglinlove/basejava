package com.basicmath;

import java.util.Random;

/**
 * 闰年
 * @author zhanglin
 *
 */
public class LeapYear {

	public static void main(String[] args) {
		Random r = new Random();
		calculate(r.nextInt(2017));
	}
	
	public static void calculate(int year) {
		if (((year % 400 == 0) || (year % 100 != 0)) && year % 4 == 0) {
			System.out.println(year + " 是闰年");
		} else {
			System.out.println(year + " 不是闰年");
		}
	}
}
