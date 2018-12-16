package com.current.part01;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {

	private LinkedList<String> buffer;
	private int maxSize;
	private ReentrantLock lock;
	private Condition lines;
	private Condition space;
	private boolean pendingLines;
	
	public Buffer(int maxSize) {
		this.buffer = new LinkedList<>();
		this.maxSize = maxSize;
		lock = new ReentrantLock();
		lines = lock.newCondition();
		space = lock.newCondition();
		pendingLines = true;
	}
	
	public void insert(String line) {
		lock.lock();
		try {
			while (buffer.size() == maxSize) {
				space.await();
			}
			buffer.offer(line);
			System.out.printf("%s insert line: %d\n", Thread.currentThread().getName(),
					buffer.size());
			lines.signalAll();
		} catch (InterruptedException e) {
			
		} finally {
			lock.unlock();
		}
	}
	
	public boolean hasPendingLines() {
		return pendingLines || buffer.size() > 0;
	}
	
	public void setPendingLines(boolean pendingLines) {
		this.pendingLines = pendingLines;
	}
	
	public String get() {
		String line = null;
		lock.lock();
		try {
			while (buffer.size() == 0 && (hasPendingLines())) {
				lines.await();
			}
			if (hasPendingLines()) {
				line = buffer.poll();
				System.out.printf("%s : Line readed: %d\n", Thread.currentThread().getName()
						, buffer.size());
				space.signalAll();
			}
		} catch (InterruptedException e) {
			
		} finally {
			lock.unlock();
		}
		return line;
	}
}
