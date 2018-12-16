package com.jvm.part07;

public class FinalFieldClass {

	public static final String constString = "CONST";
	
	static {
		System.out.println("FinalFieldClass init...");
	}
}
