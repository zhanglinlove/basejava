package com.s1;

public class ProxyTest {

	public static void main(String[] args) {
		UserDao user = new UserDao();
		ProxyFactory proxy = new ProxyFactory(user);
		UserDao instance = (UserDao) proxy.getProxyInstance();
		instance.save();
	}
}
