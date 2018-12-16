package com.current.part04;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class FactoryCalculator implements Callable<Integer>{

	private Integer number;
	
	public FactoryCalculator(Integer number) {
		this.number = number;
	}
	
	@Override
	public Integer call() throws Exception {
		int result = 1;
		if (number == 0 || number == 1) {
			result =1;
		} else {
			for (int i = 0; i <= number; i++) {
				result *= i;
				TimeUnit.MILLISECONDS.sleep(30);
			}
		}
		System.out.println(Thread.currentThread().getName() + ":" + result);
		return result;
	}

}
