package com.current.part04;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
/**
 * 缓存线程池
 * @author zhanglin
 *
 */
public class Server {

	private ThreadPoolExecutor executor;
	
	public Server() {
		executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
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
