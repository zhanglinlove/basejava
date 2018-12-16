package com.sheji.strategy;

public class AdvancedMemberStrategy implements MemberStrategy{

	@Override
	public double calcPrice(double price) {
		System.out.println("高级会员折扣20%");
		return price * 0.8;
	}

}
