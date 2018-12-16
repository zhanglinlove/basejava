package com.jvm.part01;

public class SimpleArgs {

	public static void main(String[] args) {
		for (int s = 0; s < args.length; s++) {
			System.out.println("参数" + s + ":" + args[s]);
		}
		System.out.println("-Xmx" + Runtime.getRuntime().maxMemory()/1000/1000 + "M");
	}
}
