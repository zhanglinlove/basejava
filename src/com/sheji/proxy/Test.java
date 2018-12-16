package com.sheji.proxy;

public class Test {

	public static void main(String[] args) {
		UserImpl u = new UserImpl();
		
		UserProxy p = new UserProxy(u);
		p.save();
	}
}
