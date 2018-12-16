package com.sheji.proxy;

public class Test2 {

	public static void main(String[] args) {
		User u = new UserImpl();
		
		User proxy = (User) new ProxyNewFactory(u).getInstance();
		proxy.save();
	}
}
