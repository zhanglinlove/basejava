package com.thread.part05;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Test2 {

	public static void main(String[] args) {
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("hello world!");
			}
		};
		ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
		// 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间
		service.scheduleAtFixedRate(r, 11, 1, TimeUnit.SECONDS);
	}
}
