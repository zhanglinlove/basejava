package com.current.part04;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
/**
 * 创建固定数量线程的线程池。
 * @author zhanglin
 *
 */
public class Server2 {

private ThreadPoolExecutor executor;
	
	public Server2() {
		executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
	}
	
	public void executeTask(Task task) {
		System.out.println("a new task has arrive.");
		executor.execute(task);
		System.out.println("server: pool size " + executor.getPoolSize());
		System.out.println("server: active count " + executor.getActiveCount());
		System.out.println("server: complete task count " + executor.getCompletedTaskCount());
	}
	
	public void endServer() {
		executor.shutdown();
	}
}
