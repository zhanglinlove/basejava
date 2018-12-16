package com.sheji.strategy;

public class PrimaryMemberStrategy implements MemberStrategy{

	@Override
	public double calcPrice(double price) {
		System.out.println("对于初级会员没有折扣。");
		return price;
	}

}
