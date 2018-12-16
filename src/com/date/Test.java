package com.date;

import java.time.LocalDate;

public class Test {

	public static void main(String[] args) {
		String s = "1999-09-08";
		LocalDate d = LocalDate.parse(s);
		System.out.println(d);
	}
}
