package com.sheji.strategy;
/**
 * 策略模式
 * @author zhanglin
 *
 */
public class Client {

	public static void main(String[] args) {
		MemberStrategy member = new AdvancedMemberStrategy();
		Price p = new Price(member);
		double quote = p.quote(300);
		System.out.println("零售价格为：" + quote);
	}
}
