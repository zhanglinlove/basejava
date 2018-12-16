package com.sheji.strategy;

public class Price {

	private MemberStrategy memberStrategy;
	
	public Price(MemberStrategy memberStrategy) {
		this.memberStrategy = memberStrategy;
	}
	
	public double quote(double bookprice) {
		return memberStrategy.calcPrice(bookprice);
	}
}
