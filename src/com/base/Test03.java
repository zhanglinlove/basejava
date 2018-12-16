package com.base;

public class Test03 {

	public static void main(String[] args) {
		Son s = new Son();
		Class clazz = Son.class;
		String superName = clazz.getSuperclass().getName();
		System.out.println("父类名称：" + superName);
		
		Class[] interfaces = clazz.getSuperclass().getInterfaces();
		if (interfaces == null || interfaces.length == 0) {
			System.out.println("-------");
		}
		if (s instanceof Base) {
			System.out.println("Son is same as base.");
		}
		for (int i = 0; i < interfaces.length; i++) {
			System.out.println("name=" + interfaces[i].getName());
		}
	}
}
