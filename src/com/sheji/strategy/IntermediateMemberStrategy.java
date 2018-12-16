package com.sheji.strategy;

public class IntermediateMemberStrategy implements MemberStrategy{

	@Override
	public double calcPrice(double price) {
		System.out.println("中级会员的折扣是10%");
		return price * 0.9;
	}

}
