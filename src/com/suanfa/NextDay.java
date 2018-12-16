package com.suanfa;

import java.util.Date;

public class NextDay {

	public static void main(String[] args) {
		Date d = new Date();
		getNextDay(d);
	}
	
	public static void getNextDay(Date date) {
		long time = 1l;
		time = time * 1;
		time *= 24;
		time *= 60;
		time *= 60;
		time *= 1000;
		Date d = new Date(date.getTime() + time);
		
	}
}
