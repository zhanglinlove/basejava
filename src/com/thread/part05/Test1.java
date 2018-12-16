package com.thread.part05;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Test1 {

	private static Timer time = new Timer();
	static public class MyTask extends TimerTask {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("运行了！时间为：" + new Date());
		}
		
	}
	
	public static void main(String[] args) {
		MyTask task = new MyTask();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = "2017-10-07 19:08:23";
		try {
			Date d = sdf.parse(dateString);
			System.out.println("字符串时间：" + d.toLocaleString() 
					+ ";当前时间：" + new Date().toLocaleString());
			time.schedule(task, d, 5000);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
