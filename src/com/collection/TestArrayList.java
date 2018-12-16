package com.collection;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class TestArrayList<E> implements Cloneable, Serializable{

	private Object[] items;
	private int size;
	private static final int DEFAULT_CAPACITY = 16;
	private static final Object[] EMPTY_ARRAY = {};
	private transient int modCount = 0;
	
	public TestArrayList(int capacity) {
		if (capacity > 0) {
			items = new Object[capacity];
		} else if (capacity == 0) {
			items = EMPTY_ARRAY;
		} else {
			throw new IllegalArgumentException("IllegalArgument capacity:" + capacity);
		}
	}
	
	public TestArrayList() {
		items = EMPTY_ARRAY;
	}
	
	private void ensureCapacityInternal(int oldCapacity) {
		if (items == EMPTY_ARRAY) {
			oldCapacity = Math.max(DEFAULT_CAPACITY, oldCapacity);
		}
		ensureExplicitCapacity(oldCapacity);
	}
	
	private void ensureExplicitCapacity(int minCapacity) {
		modCount++;
		if (minCapacity - items.length > 0) {
			grow(minCapacity);
		}
	}
	
	private void grow(int minCapacity) {
		int oldCapacity = items.length;
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		if (newCapacity < minCapacity) {
			newCapacity = minCapacity;
		} 
		if (newCapacity > Integer.MAX_VALUE) {
			newCapacity = Integer.MAX_VALUE;
		}
		items = Arrays.copyOf(items, newCapacity);
	}
	
	private void rangeCheck(int index) {
		if (index < 0 || index >= items.length) {
			throw new IndexOutOfBoundsException();
		}
	}
	
	public int size() {
		return size;
	}
	
	public boolean empty() {
		return size == 0;
	}
	
	public E get(int index) {
		rangeCheck(index);
		E element = (E) items[index];
		return element;
	}
	
	public int indexOf(Object o) {
		
		if (o == null) {
			for (int i = 0; i < size; i++) {
				if (o == items[i]) {
					return i;
				}
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (o == items[i]) {
					return i;
				}
			}
		}
		return -1;
	}
	
	
	public boolean conatins(Object o) {
		return indexOf(o) >= 0;
	}
	
	public boolean add(Object o) {
		ensureCapacityInternal(size + 1);
		items[size++] = o;
		return true;
	}
	
	public void add(int index, E e) {
		rangeCheck(index);
		ensureCapacityInternal(size + 1);
		System.arraycopy(items, index, items, index + 1, size - index);
		items[index] = e;
		size++;
	}
	
	public E set(int index, E e) {
		rangeCheck(index);
		E oldValue = (E) items[index];
		items[index] = e;
		return oldValue;
	}
	
	public int lastIndexOf(Object o) {
		if (o == null) {
			for (int i = size - 1; i >= 0; i--) {
				if (o == items[i]) {
					return i;
				}
			}
		} else {
			for (int i = size - 1; i >= 0; i--) {
				if (o == items[i]) {
					return i;
				}
			}
		}
		return -1;
	}
	
	public Object clone() {
		try {
			TestArrayList<?> list = (TestArrayList<?>) super.clone();
			list.items = Arrays.copyOf(items, size);
			list.modCount = 0;
			return list;
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			throw new InternalError(e);
		}
		
	}
	
	public Object[] toArray() {
		return Arrays.copyOf(items, size);
	}
	
	public <T> T[] toArray(T[] a) {
		if (a.length < size)
			return (T[]) Arrays.copyOf(items, size, a.getClass());
		System.arraycopy(items, 0, a, 0, size);
		if (a.length > size) {
			a[size] = null;
		}
		
		return a;
	}
	
	public E remove(int index) {
		rangeCheck(index);
		modCount++;
		E oldElement = (E) items[index];
		int len = items.length - index - 1;
		if (len > 0) {
			System.arraycopy(items, index + 1, items, index, len);
		}
		items[--size] = null;
		return oldElement;
	}
	
	public boolean remove(Object o) {
		if ( o == null) {
			for (int i = 0; i < size; i++) {
				if (o == items[i]) {
					fastMove(i);
					return true;
				}
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (o == items[i]) {
					fastMove(i);
					return true;
				}
			}
		}
		return false;
	}
	
	private void fastMove(int index) {
		modCount++;
		int len = items.length - index - 1;
		if (len > 0) {
			System.arraycopy(items, index + 1, items, index, len);
		}
		items[--size] = null;
	}
	
	public void clear() {
		for (int i = 0; i < size; i++) {
			items[i] = null;
		}
		size = 0;
	}
	
	public boolean addAll(Collection<? extends E> c) {
		Object[] a = c.toArray();
		int newSize = a.length;
		ensureCapacityInternal(newSize + size);
		System.arraycopy(a, 0, items, size, newSize);
		size += newSize;
		return newSize != 0;
	}
	
	public boolean addAll(int index, Collection<? extends E> c) {
		rangeCheck(index);
		Object[] a = c.toArray();
		int newSize = a.length;
		ensureCapacityInternal(newSize + size);
		int len = size - index;
		if (len > 0) {
			System.arraycopy(items, index, items, index + newSize, len);
		}
		System.arraycopy(a, 0, items, index, newSize);
		size += newSize;
		return newSize != 0;
	}
	
	public Iterator iterator() {
		return new Itr();
	}
	
	public ListItr listItr() {
		return new ListItr(0);
	}
	
	private class Itr implements Iterator{
		int cursor;
		int lastRet = -1;
		int expectedModCount = modCount;
		
		public boolean hasNext() {
			return cursor != size;
		}
		
		final void checkConModified() {
			if (modCount != expectedModCount) {
				throw new ConcurrentModificationException();
			}
		}
		
		public E next() {
			checkConModified();
			int i = cursor;
			if (i > size)
				throw new NoSuchElementException();
			Object[] obj = TestArrayList.this.items;
			if (i > obj.length)
				throw new ConcurrentModificationException();
			cursor = i + 1;
			return (E) obj[lastRet = i];
		}
		
		public void remove() {
			if (lastRet < 0)
				throw new IllegalStateException();
			checkConModified();
			
			TestArrayList.this.remove(lastRet);
			expectedModCount = modCount;
			cursor = lastRet;
			lastRet = -1;
		}
	}
	
	private class ListItr extends Itr{
		ListItr(int index) {
			super();
			cursor = index;
		}
		
		public boolean hasPrevious() {
			return cursor != 0;
		}
		
		public int nextIndex() {
			return cursor;
		}
		
		public int previousIndex() {
			return cursor - 1;
		}
		
		public E previous() {
			checkConModified();
			int i = cursor - 1;
			if (i < 0)
				throw new NoSuchElementException();
			Object[] obj = TestArrayList.this.items;
			if (i > obj.length)
				throw new ConcurrentModificationException();
			cursor = i;
			return (E) obj[lastRet = i];
		}
		
		public void set(E e) {
			if (lastRet < 0)
				throw new NoSuchElementException();
			checkConModified();
			TestArrayList.this.set(lastRet, e);
		}
		
		public void add(E e) {
			checkConModified();
			int i = cursor;
			TestArrayList.this.add(i, e);
			lastRet = -1;
			expectedModCount = modCount;
			cursor = i + 1;
		}

	}
}
