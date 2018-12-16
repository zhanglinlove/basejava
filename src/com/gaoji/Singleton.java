package com.gaoji;
/**
 * 单例
 * @author zhanglin
 *
 */
public class Singleton {

	private Singleton() {}
	
	public static Singleton getInstance() {
		return innerClass.single;
	}
	
	private static class innerClass {
		static Singleton single = new Singleton();
	}
}
