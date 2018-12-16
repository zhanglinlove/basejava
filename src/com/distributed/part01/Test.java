package com.distributed.part01;

import java.lang.ref.SoftReference;

public class Test {

	public static void main(String[] args) {
		Student stu = new Student();
		stu.setAge(22);
		stu.setName("张三");
		SoftReference<Student> soft = new SoftReference<Student>(stu);
		Student s = soft.get();
		if (s != null) {
			System.out.println(s.toString());
		} else {
			System.out.println("stu is null");
		}
		stu = null;
		System.gc();
		s = soft.get();
		if (s == null) {
			System.out.println("object is gc");
		} else {
			System.out.println("object is exists.");
		}
	}

}
