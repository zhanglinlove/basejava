package com.jvm.part03;

public class HeapAlloc {

	public static void main(String[] args) {
		System.out.println("maxMemory=");
		System.out.println(Runtime.getRuntime().maxMemory() + " bytes");
		System.out.println("free mem=");
		System.out.println(Runtime.getRuntime().freeMemory() + " bytes");
		System.out.println("total mem=");
		System.out.println(Runtime.getRuntime().totalMemory() + " bytes");
		
		byte[] b = new byte[1 * 1024 * 1024];
		System.out.println("分配了1M空间给数组");
		
		System.out.println("maxMemory=");
		System.out.println(Runtime.getRuntime().maxMemory() + " bytes");
		System.out.println("free mem=");
		System.out.println(Runtime.getRuntime().freeMemory() + " bytes");
		System.out.println("total mem=");
		System.out.println(Runtime.getRuntime().totalMemory() + " bytes");
		
		b = new byte[4 * 1024 * 1024];
		System.out.println("maxMemory=");
		System.out.println(Runtime.getRuntime().maxMemory() + " bytes");
		System.out.println("free mem=");
		System.out.println(Runtime.getRuntime().freeMemory() + " bytes");
		System.out.println("total mem=");
		System.out.println(Runtime.getRuntime().totalMemory() + " bytes");
	}
}
