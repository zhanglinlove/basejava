package com.sheji;

public class Test8 {

	public static void main(String[] args) {
		Bridge b = new BridgeImp();
		
		Change c1 = new Sub1();
		Change c2 = new Sub2();
		
		b.setChange(c1);
		b.method();
		
		b.setChange(c2);
		b.method();
	}
}
