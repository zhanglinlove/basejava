package com.s1;

import java.util.NoSuchElementException;

/**
 * 初始化、表的长度、获取节点，查询节点、插入节点、删除节点
 * @author zhanglin
 *
 * @date 2018年7月1日
 */
public class MyLinkedList {

	private Data2 head;
	private Data2 tail;
	private int length;
	
	public MyLinkedList() {
		head = null;
		tail = null;
	}
	
	public int size() {
		return length;
	}
	
	public Data2 removeLast() {
		Data2 l = tail;
		if (l == null)
			throw new NoSuchElementException();
		Data2 prev = l.prev;
		tail = prev;
		l.data = null;
		l.prev = null;
		if (tail == null)
			head = null;
		else
			tail.next = null;
		length--;
		return l;
	}
	
	public Data2 removeFirst() {
		Data2 f = head;
		if (f == null)
			throw new NoSuchElementException();
		Data2 next = f.next;
		f.prev = null;
		f.data = null;
		head = next;
		if (next == null)
			tail = next;
		else
			head.prev = null;
		length--;
		return f;
		
	}
	
	public void addLast(String data) {
		Data2 d = new Data2(data, null, tail);
		Data2 l = tail;
		tail = d;
		if (l == null)
			head = d;
		else
			l.next = d;
		length++;
	}
	
	public void addFirst(String data) {
		Data2 d = new Data2(data, head, null);
		Data2 f = head;
		head = d;
		if (f == null)
			tail = d;
		else
			f.prev = d;
		length++;
	}
	
	public Data2 getFirst() {
		Data2 f = head;
		if (f == null)
			throw new NoSuchElementException();
		return f;
	}
	
	public Data2 getLast() {
		Data2 l = tail;
		if (l == null)
			throw new NoSuchElementException();
		return l;
	}
	
	public boolean isExists(Data2 obj) {
		return indexOf(obj) != -1;
	}
	
	public int indexOf(Data2 obj) {
		int index = 0;
		if (obj == null) {
			for (Data2 d = head; d != null; d = d.getNext()) {
				if (d.getData() == null)
					return index;
				index++;
			}
		} else {
			for (Data2 d = tail; d != null; d = d.getPrev()) {
				if (d.getPrev() == null)
					return index;
				index++;
			}
		}
		return -1;
	}
	
	public Data2 search(int index) {
		checkRange(index);
		if (index < (length >> 1)) {
			Data2 d = head;
			for (int i = 0; i < index; i++) 
				d = head.getNext();
			return d;
		} else {
			Data2 d = tail;
			for (int j = 0; j < index; j++)
				d = tail.getPrev();
			return d;
		}
	}
	
	private void checkRange(int index) {
		if (index >= length || index < 0) {
			throw new IllegalArgumentException("非法参数");
		}
	}
}
