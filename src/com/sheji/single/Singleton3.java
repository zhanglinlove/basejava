package com.sheji.single;
/**
 * 静态内部类
 * @author zhanglin
 *
 */
public class Singleton3 {

	public static Singleton3 getInstace() {
		return Inner.instance;
	}
	
	private static class Inner {
		private static final Singleton3 instance = new Singleton3();
	}
}
