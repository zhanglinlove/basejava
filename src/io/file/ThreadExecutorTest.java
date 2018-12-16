package io.file;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadExecutorTest {

	private volatile boolean RUNNING = true;
	private static BlockingQueue<Runnable> queue = null;
	private final HashSet<Worker> workers = new HashSet<>();
	private final List<Thread> threadList = new ArrayList<>();
	AtomicInteger poolSize = new AtomicInteger(0);
	private volatile int coreSize = 0;
	boolean shutdown = false;
	
	public ThreadExecutorTest(int poolSize) {
		this.poolSize = new AtomicInteger(poolSize);
		queue = new LinkedBlockingQueue<>();
	}
	
	public void exc(Runnable runnable) {
		if (runnable == null)
			throw new NullPointerException();
		int c = poolSize.get();
		if (coreSize < c) {
			addTask(runnable);
		} else {
			queue.offer(runnable);
		}
	}
	
	public void shutdow() {
		RUNNING = false;
		if (!workers.isEmpty()) {
			for (Thread thread : threadList) {
				System.out.println(thread.getName() + " interrupted");
				thread.interrupt();
			}
		}
	}
	
	private void addTask(Runnable runnable) {
		coreSize++;
		Worker worker = new Worker(runnable);
		workers.add(worker);
		Thread t = new Thread(worker);
		threadList.add(t);
		t.start();
	}
	
	class Worker implements Runnable {

		public Worker(Runnable runnable) {
			queue.offer(runnable);
		}
		
		@Override
		public void run() {
			while (true && RUNNING) {
				if (shutdown == true)
					Thread.interrupted();
				Runnable runnable = null;
				try {
					runnable = getTask();
					runnable.run();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		public Runnable getTask() throws InterruptedException {
			return queue.take();
		}
	}
}
