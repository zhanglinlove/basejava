package com.current.part02;

public class Writer implements Runnable{

	private PriceInfo priceInfo;
	
	public Writer(PriceInfo priceInfo) {
		this.priceInfo = priceInfo;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			System.out.println("attempt to modify price.");
			priceInfo.setPrice(Math.random() * 15, Math.random() * 8);
			System.out.println("price has been modify.");
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
