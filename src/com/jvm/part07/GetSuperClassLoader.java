package com.jvm.part07;

public class GetSuperClassLoader {

	public static void main(String[] args) {
		ClassLoader loader = GetSuperClassLoader.class.getClassLoader();
		System.out.println("当前类加载器->" + loader.getClass().getName());
		
		ClassLoader parent = loader.getParent();
		System.out.println("父类加载器->" + parent.getClass().getName());
	}
}
