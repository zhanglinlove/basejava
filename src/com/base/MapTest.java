package com.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest {

	public static void main(String[] args) {
		Map<String, Employee> staff = new HashMap<>();
		List list = new ArrayList<>();
		staff.put("1", new Employee("zhangsan"));
		staff.put("2", new Employee("lisi"));
		staff.put("3", new Employee("wangwu"));
		System.out.println(staff);
		
		staff.remove("1");
		staff.put("4", new Employee("zhaoliu"));
		System.out.println(staff.get("2"));
		
		staff.forEach((k, v)->System.out.println("key=" + k
					+ ",value=" + v));
			
	}
}
