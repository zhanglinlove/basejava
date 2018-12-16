package com.base;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

	private static DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");
	
	public static long dateToLong(OffsetDateTime time) {
		String s = time.format(format);
		String[] arr = s.split(":");
		return Integer.valueOf(arr[0]) * 3600 + Integer.valueOf(arr[1]) * 60 + Integer.valueOf(arr[2]);
	}
}
