package com.sheji.proxy;
/**
 * cglib代理
 * @author zhanglin
 *
 */
public class App {

	public static void main(String[] args) {
		UserMap u = new UserMap();
		
		UserMap proxy = (UserMap) new ProxyNewFactory(u).getInstance();
		proxy.save();
	}
}
