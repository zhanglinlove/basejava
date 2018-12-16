package com.interview;

import java.math.BigDecimal;
import java.text.NumberFormat;
/**
 * 商业计算一般用BigDecimal.
 * @author zhanglin
 *
 */
public class DecimalTest {

	public static void main(String[] args) {
		BigDecimal b1 = new BigDecimal("15.66");
		BigDecimal b2 = new BigDecimal("22.3");
		System.out.println(b1.add(b2).doubleValue());
		System.out.println("-------------------------");
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		NumberFormat percent = NumberFormat.getPercentInstance();
		percent.setMaximumFractionDigits(3);
		BigDecimal loanAmount = new BigDecimal("1500");
		BigDecimal rate = new BigDecimal("0.0035");
		BigDecimal interest = loanAmount.multiply(rate).divide(new BigDecimal(365), 3, BigDecimal.ROUND_DOWN);
		
		System.out.println("本金是：" + currency.format(loanAmount));
		System.out.println("利率是:" + percent.format(rate));
		System.out.println("利息是：" + currency.format(interest));
	}
}
