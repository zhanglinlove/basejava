package com.current.part04;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test5 {

	public static void main(String[] args) {
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
		Task7 t = new Task7();
		System.out.println("start task:");
		Future<String> future = executor.submit(t);
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("cancel task.");
		future.cancel(true);
		System.out.println("task is cancel:" + future.isCancelled()
					+ "; isDone:" + future.isDone());
		executor.shutdown();
		System.out.println("executor has finished.");
	}
}
