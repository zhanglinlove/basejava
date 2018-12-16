package com.jvm.part01;

public class SimpleArg {

	public static void main(String[] args) {
		for (int i = 0; i < args.length; i++) {
			System.out.println("参数" + (i + 1) + ":" + args[0]);
		}
		System.out.println("-Xmx:" + Runtime.getRuntime().maxMemory()/1000/1000 + "M");
	}

}
