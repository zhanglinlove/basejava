package com.collection;

import java.io.Serializable;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class TestLinkedList<E> implements Cloneable, Serializable{

	private int size;
	private Node<E> first;
	private Node<E> last;
	private transient int modCount;
	
	public TestLinkedList() {
		
	}
	
	/**
	 * Unlinks non-null node x.
	 * 
	 */
	private E unlink(Node<E> x) {
		Node<E> prev = x.prev;
		Node<E> next = x.next;
		final E e = x.element;

		if (prev == null)
			first = next;
		else {
			prev.next = next;
			x.prev = null;
		}	
		if (next == null)
			last = prev;
		else {
			next.prev = prev;
			x.next = null;
		}
		x.element = null;
		size--;
		modCount++;
		return e;
	}
	
	private E unlinkLast(Node<E> l) {
		final Node<E> prev = l.prev;
		final E e = l.element;
		l.element = null;
		l.prev = null;
		last = prev;
		if (prev == null)
			first = null;
		else
			prev.next = null;
		size--;
		modCount++;
		return e;
	}
	
	/**
	 * Unlinks non-null first node f
	 * @param f
	 * @return
	 */
	private E unlinkFirst(Node<E> f) {
		final Node<E> next = f.next;
		final E e = f.element;
		f.element = null;
		f.next = null;
		if (next == null)
			last = null;
		else
			next.prev = null;
		first = next;
		size--;
		modCount++;
		return e;
	}
	
	private void linkBefore(E e, Node<E> succ) {
		Node<E> prev = succ.prev;
		Node<E> newNode = new Node<>(prev, e, succ);
		succ.prev = newNode;
		if (prev == null)
			first = newNode;
		else
			prev.next = newNode;
		size++;
		modCount++;
	}
	
	private void linkLast(E e) {
		final Node<E> l = last;
		Node<E> newNode = new Node(l, e, null);
		last = newNode;
		if (l == null) {
			first = newNode;
		} else {
			l.next = newNode;
		}
		size++;
		modCount++;
	}
	
	private void checkIndex(int index) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException();
	}
	
	private void linkFirst(E e) {
		final Node l = first;
		Node<E> newNode = new Node(null, e, l);
		first = newNode;
		if (l == null) {
			last = null;
		} else {
			l.prev = first;
		}
		size++;
		modCount++;
	}
	
	public boolean remove(Object o) {
		if (o == null) {
			for (Node<E> e = first; e != null; e = e.next) {
				if (o == e)
					return true;
			}
		} else {
			for (Node<E> e = first; e != null; e = e.next) {
				if (o.equals(e))
					return true;
			}
		}
		return false;
	}
	
	public boolean add(E e) {
		linkLast(e);
		return true;
	}
	
	public E remove(int index) {
		checkIndex(index);
		return unlink(node(index));
	}
	
	public void add(int index, E e) {
		checkIndex(index);
		Node<E> succ = node(index);
		if (size == index)
			linkLast(e);
		else
			linkBefore(e, succ);
	}
	
	public E set(int index, E e) {
		checkIndex(index);
		Node<E> n = node(index);
		E oldValue = n.element;
		n.element = e;
		return oldValue;
	}
	
	public E get(int index) {
		checkIndex(index);
		return node(index).element;
	}
	
	public void clear() {
		for (Node<E> e = first; e != null;) {
			Node<E> next = e.next;
			e.element = null;
			e.prev = null;
			e.next = null;
			e = next;
		}
		first = last = null;
		size = 0;
		modCount++;
	}
	
	public boolean contains(Object o) {
		return indexOf(o) != -1;
	}
	
	public boolean addAll(Collection<? extends E> c) {
		return addAll(size, c);
	}
	
	public boolean addAll(int index, Collection<? extends E> c) {
		checkIndex(index);
		Object[] a = c.toArray();
		Node<E> pred, succ;
		int newNum = a.length;
		if (newNum == 0) {
			return false;
		}
		if (size == index) {
			succ = null;
			pred = last;
		} else {
			succ = node(index);
			pred = succ.prev;
		}
		for (Object o : a) {
			
			Node<E> e = new Node<>(pred, (E)o, null);
			if (pred == null) {
				first = e;
			} else {
				pred.next = e;
			}
			pred = e;
		}
		if (succ == null) {
			last = pred;
		} else {
			succ.prev = pred;
			pred.next = succ;
		}
		size += newNum;
		modCount++;
		return true;
	}
	
	Node<E> node(int index) {
		if (index < (size >> 1)) {
			Node<E> n = first;
			for (int i = 0; i < index; i++)
				n = n.next;
			return n;
		} else {
			Node<E> n = last;
			for (int i = size -1; i > index; i--)
				n = n.prev;
			return n;
		}
	}
	
	public int lastIndexOf(Object o) {
		int index = size;
		if (o == null) {
			for (Node<E> e = last; e != null; e = e.prev) {
				index--;
				if (e.element == null) {
					return index;
				}
			}
		} else {
			for (Node<E> e = last; e != null; e = e.prev) {
				index--;
				if (o.equals(e.element)) {
					return index;
				}
			}
		}
		return -1;
	}
	
	public int indexOf(Object o) {
		int index = 0;
		if (o == null) {
			for (Node<E> e = first; e != null; e = e.next) {
				if (o == e.element) {
					return index;
				}
				index++;
			}
		} else {
			for (Node<E> e = first; e != null; e = e.next) {
				if (o.equals(e)) {
					return index;
				}
				index++;
			}
		}
		return -1;
	}
	
	public E peek() {
		Node<E> n = first;
		return (n == null) ? null : n.element;
	}
	
	public E element() {
		return getFirst();
	}
	
	public E poll() {
		Node<E> n = first;
		return (n == null) ? null : unlink(n);
	}
	
	public E remove() {
		 return removeFirst();
	}
	
	public int size() {
		return size;
	}
	
	public void addLast(E e) {
		linkLast(e);
	}
	
	public void addFirst(E e) {
		linkFirst(e);
	}
	
	public E removeLast() {
		Node<E> l = last;
		if (l == null)
			throw new NoSuchElementException();
		return unlink(l);
	}
	
	public E removeFirst() {
		Node<E> f = first;
		if (f == null)
			throw new NoSuchElementException();
		return unlinkFirst(f);
	}
	
	public E getLast() {
		Node<E> l = last;
		if (l == null)
			throw new NoSuchElementException();
		return l.element;
	}
	
	public E getFirst() {
		Node<E> f = first;
		if (f == null)
			throw new NoSuchElementException();
		return f.element;
	}
	
	public boolean offer(E e) {
		return add(e);
	}
	
	private static class Node<E> {
		E element;
		Node<E> next;
		Node<E> prev;
		
		public Node(Node<E> prev, E element, Node<E> next) {
			this.element = element;
			this.prev = prev;
			this.next = next;
		}
	}
	
	private class ListItr implements ListIterator<E> {

		private Node<E> lastReturned;
		private Node<E> next;
		private int nextIndex;
		private int expectedModCount = modCount;
		
		ListItr(int index) {
			next = (size == index) ? null : node(index);
			nextIndex = index;
		}
		
		private void checkConModified() {
			if (expectedModCount != modCount)
				throw new ConcurrentModificationException();
		}
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return nextIndex < size;
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			checkConModified();
			if (!hasNext())
				throw new NoSuchElementException();
			lastReturned = next;
			next = next.next;
			nextIndex++;
			return lastReturned.element;
		}

		@Override
		public boolean hasPrevious() {
			// TODO Auto-generated method stub
			return nextIndex > 0;
		}

		@Override
		public E previous() {
			// TODO Auto-generated method stub
			checkConModified();
			if (!hasPrevious())
				throw new NoSuchElementException();
			lastReturned = next = (next == null) ? last : next.prev;
			nextIndex--;
			return lastReturned.element;
		}

		@Override
		public int nextIndex() {
			// TODO Auto-generated method stub
			return nextIndex;
		}

		@Override
		public int previousIndex() {
			// TODO Auto-generated method stub
			return nextIndex - 1;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			checkConModified();
			if (lastReturned == null)
				throw new NoSuchElementException();
			Node<E> lastNext = lastReturned.next;
			unlink(lastReturned);
			if (next == lastReturned)
				next = lastNext;
			else
				nextIndex--;
			expectedModCount++;
			lastReturned = null;
		}

		@Override
		public void set(E e) {
			// TODO Auto-generated method stub
			if (lastReturned == null)
				throw new IllegalArgumentException();
			checkConModified();
			lastReturned.element = e;
		}

		@Override
		public void add(E e) {
			// TODO Auto-generated method stub
			checkConModified();
			if (next == null)
				linkLast(e);
			else
				linkBefore(e, next);
			nextIndex++;
			expectedModCount++;
		}
		
	}
}
