package com.audition;

public class UserUtil {

	private static Student obj;
	
	static {
		obj = new Student();
		obj.setAddress("北京市朝阳区");
		obj.setAge(32);
		obj.setName("李四");
	}
	
	public static String getUser() {
		System.out.println(obj.toString());
		return "success";
	}
}
