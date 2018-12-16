package com.thread.part07;

import java.text.SimpleDateFormat;

public class Test2 {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String[] dateStringArray = new String[] {"2001-09-01","2002-09-01","2003-09-01"
									, "2004-09-01","2005-09-01","2006-09-01","2007-09-01","2008-09-01"};
		MyThread2[] threadArray = new MyThread2[8];
		for (int i = 0; i < 8; i++) {
			threadArray[i] = new MyThread2(sdf, dateStringArray[i]);
		}
		for (int i = 0; i < 8; i++) {
			threadArray[i].start();
		}
	}
}
