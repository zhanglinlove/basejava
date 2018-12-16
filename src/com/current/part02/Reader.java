package com.current.part02;

public class Reader implements Runnable{

	private PriceInfo priceInfo;
	
	public Reader(PriceInfo priceInfo) {
		this.priceInfo = priceInfo;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + ";price1="
						+ priceInfo.getPrice1());
			System.out.println(Thread.currentThread().getName() + ";price2:" 
						+ priceInfo.getPrice2());
		}
	}

}
