package com.collection;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TestArrayBlockingQueue<E> {

	private Object[] items;
	private int takeIndex;
	private int putIndex;
	private int count;
	private final ReentrantLock lock;
	private final Condition notFull;
	private final Condition notEmpty;
	
	public TestArrayBlockingQueue(int capacity) {
		this(capacity, false);
	}
	
	public TestArrayBlockingQueue(int capacity, boolean fair) {
		items = new Object[capacity];
		lock = new ReentrantLock(fair);
		notFull = lock.newCondition();
		notEmpty = lock.newCondition();
	}
	
	private static void checkNotNull(Object e) {
		if (e == null) {
			throw new NullPointerException();
		}
	}
	
	private void enqueue(E e) {
		final Object[] items = this.items;
		items[putIndex] = e;
		if (++putIndex == items.length)
			putIndex = 0;
		count++;
		notEmpty.signal();
	}
	
	private E dequeue() {
		final Object[] items = this.items;
		E e = (E) items[takeIndex];
		items[takeIndex] = null;
		if (++takeIndex == items.length)
			takeIndex = 0;
		count--;
		notFull.signal();
		return e;
	}
	
	public void add(E e) throws InterruptedException {
		checkNotNull(e);
		final ReentrantLock lock = this.lock;
		lock.lock();
		try {
			while (count == items.length)
				notFull.await();
			enqueue(e);
		} finally {
			lock.unlock();
		}
	}
	
	public boolean put(E e, TimeUnit unit, long timeout) throws InterruptedException {
		checkNotNull(e);
		final ReentrantLock lock = this.lock;
		long nanos = unit.toNanos(timeout);
		lock.lock();
		try {
			while (count == items.length) {
				if (nanos <= 0) {
					return false;
				}
				nanos = notFull.awaitNanos(nanos);
			}
			enqueue(e);
			return true;
		} finally {
			lock.unlock();
		}
	}
	
	public E poll() {
		final ReentrantLock lock = this.lock;
		lock.lock();
		try {
			return count == 0 ? null : dequeue();
		} finally {
			lock.unlock();
		}
	}
	
	public E offer(long timeout, TimeUnit unit) throws InterruptedException {
		final ReentrantLock lock = this.lock;
		long nanos = unit.toNanos(timeout);
		lock.lock();
		try {
			while (count == 0) {
				if (nanos <= 0) {
					return null;
				}
				nanos = notEmpty.awaitNanos(nanos);
			}
			return dequeue();
		} finally {
			lock.unlock();
		}
	}
	
	final E itemAt(int i) {
		return (E) items[i];
	}
	
	public E peek() {
		final ReentrantLock lock = this.lock;
		lock.lock();
		try {
			return itemAt(takeIndex);
		} finally {
			lock.unlock();
		}
	}
}
