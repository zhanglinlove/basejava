package com.jvm.part07;

public class ClassLoaderTest {

	public static void main(String[] args) {
		ClassLoader loader = System.class.getClassLoader();
		System.out.println(loader != null ? loader.getClass().getName() : null);
		
		System.out.println(ClassLoaderTest.class.getClassLoader().getClass().getName());
	}
}
