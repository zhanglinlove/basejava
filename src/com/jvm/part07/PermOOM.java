package com.jvm.part07;

public class PermOOM {

	public static void main(String[] args) {
		for (int i = 0; i < 100000; i++) {
			Student stu = new Student("张林", "地址", 23, "man");
		}
	}
}
