package com.interview;

import java.math.BigDecimal;

public class DecimalUtils {

	/**
	 * 两个数相加.
	 * @param n
	 * @param n2
	 * @return
	 */
	public static BigDecimal addNumber(String n, String n2) {
		BigDecimal b1 = new BigDecimal(n);
		BigDecimal b2 = new BigDecimal(n2);
		return b1.add(b2);
	}
	
	/**
	 * 两个数相减。
	 * @param n
	 * @param n2
	 * @return
	 */
	public static BigDecimal subNumber(String n, String n2) {
		BigDecimal b1 = new BigDecimal(n);
		BigDecimal b2 = new BigDecimal(n2);
		return b1.subtract(b2);
	}
	
	/**
	 * 两个数相乘。
	 * @param n
	 * @param n2
	 * @return
	 */
	public static BigDecimal multiNumber(String n, String n2) {
		BigDecimal b1 = new BigDecimal(n);
		BigDecimal b2 = new BigDecimal(n2);
		return b1.multiply(b2);
	}
	
	/**
	 * 两个数相除。
	 * @param n
	 * @param n2
	 * @return
	 */
	public static BigDecimal divideNumber(String n, String n2) {
		BigDecimal b1 = new BigDecimal(n);
		BigDecimal b2 = new BigDecimal(n2);
		return b1.divide(b2, 3, BigDecimal.ROUND_DOWN);
	}
	
}
