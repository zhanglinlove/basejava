package com.sheji.proxy;
/**
 * 动态代理。
 * @author zhanglin
 *
 */
public class Test3 {

	public static void main(String[] args) {
		User u = new UserImpl();
		
		User proxy = (User) new ProxyFactory(u).getProxyInstance();
		proxy.save();
	}
}
