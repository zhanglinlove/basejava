package com.thread.part07;

import java.text.SimpleDateFormat;

public class DateUtils {

	private static ThreadLocal<SimpleDateFormat> t = new ThreadLocal<SimpleDateFormat>();
	
	public static SimpleDateFormat getInstance(String pattern) {
		SimpleDateFormat sdf = null;
		sdf = t.get();
		if (sdf == null) {
			sdf = new SimpleDateFormat(pattern);
			t.set(sdf);
		}
		return sdf;
	}
}
