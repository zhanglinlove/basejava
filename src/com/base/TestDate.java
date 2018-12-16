package com.base;

import java.time.OffsetDateTime;

public class TestDate {

	public static void main(String[] args) {
		OffsetDateTime t1 = OffsetDateTime.now();
		long m = DateUtils.dateToLong(t1);
		System.out.println(m);
		OffsetDateTime t2 = OffsetDateTime.now();
		t2 = t2.plusMinutes(-5);
		long m2 = DateUtils.dateToLong(t2);
		System.out.println(m2);
	}
}
