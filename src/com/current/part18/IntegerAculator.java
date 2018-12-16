package com.current.part18;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public final class IntegerAculator {

	private final int init;
	
	public IntegerAculator(int init) {
		this.init = init;
	}
	
	public IntegerAculator(IntegerAculator aculator, int init) {
		this.init = aculator.init + init;
	}
	
	public IntegerAculator add(int i) {
		return new IntegerAculator(this, i);
	}
	
	public int getValue() {
		return this.init;
	}
	
	public static void main(String[] args) {
		IntegerAculator a = new IntegerAculator(0);
		IntStream.range(0, 3).forEach(i -> new Thread(() -> {
			int inc = 0;
			while(true) {
				int oldValue = a.getValue();
				int result = a.add(inc).getValue();
				System.out.println(oldValue + "+" + inc + "=" + result);
				if (oldValue + inc != result) {
					System.out.println("error:" + oldValue + "+" + inc + "=" + result);
				}
				inc++;
				slowly();
			}
		}).start());
	}
	
	private static void slowly() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
