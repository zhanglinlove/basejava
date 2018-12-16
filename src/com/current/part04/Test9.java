package com.current.part04;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Test9 {

	public static void main(String[] args) {
		RejectedTaskController controller = new RejectedTaskController();
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
		executor.setRejectedExecutionHandler(controller);
		System.out.println("start..");
		for (int i = 0; i < 3; i++) {
			Task8 t = new Task8("task-" + i);
			executor.submit(t);
		}
		System.out.println("shutdown executor.");
		executor.shutdown();
		System.out.println("send another task.");
		Task8 t = new Task8("reject task");
		executor.submit(t);
		System.out.println("end");
	}
}
