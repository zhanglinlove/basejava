package com.jvm.part10;

public class Test01 {

	public static void main(String[] args) {
		ClassLoader loader = Test01.class.getClassLoader();
		while (loader != null) {
			System.out.println(loader.toString());
			loader = loader.getParent();
		}
	}

}
