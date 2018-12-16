package com.thread.part07;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyThread2 extends Thread{

	private SimpleDateFormat sdf;
	private String dateString;
	public MyThread2(SimpleDateFormat sdf, String dateString) {
		this.sdf = sdf;
		this.dateString = dateString;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			sdf = DateUtils.getInstance("yyyy-MM-dd");
			Date d = sdf.parse(dateString);
			String newStr = sdf.format(d).toString();
			if (!newStr.equals(dateString)) {
				System.out.println("thread name=" + this.getName()
						+ " 日期字符串：" + dateString + ";转换的日期："
						+ newStr);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
