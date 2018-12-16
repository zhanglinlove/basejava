package com.gaoji;
/**
 * 创建一个链表。
 * @author zhanglin
 *
 */
public class MyList {

	private static class Node {
		Object data;
		Node next;
		public Node(Object data) {
			super();
			this.data = data;
			this.next = null;
		}
	}
	
	Node head;
	public MyList() {
		this.head = null;
	}
	
	public void clear() {
		this.head = null;
	}
	
	public void travel() {
		Node p = head;
		while (p != null) {
			System.out.println(p.data);
			p = p.next;
		}
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public int size() {
		Node p = head;
		int sum = 0;
		while (p != null) {
			sum++;
			p = p.next;
		}
		return sum;
	}
	
	public void insert(Object obj, int pos) throws Exception {
		if (pos < 0 || pos > size()) {
			throw new Exception("下标异常。");
		}
		Node newNode = new Node(obj);
		if (pos == 0) {
			newNode.next = head;
			head = newNode;
		} else if (pos >= size() - 1) {
			getIndex(size() - 1).next = newNode;
			newNode.next = null;
		} else {
			newNode.next = getIndex(pos);
			getIndex(pos - 1).next = newNode;
		}
	}
	
	public Node getIndex(int pos) throws Exception {
		if (pos < 0 || pos > size()) {
			throw new Exception("下标异常。");
		}
		Node p = head;
		if (pos == 0) {
			return head;
		}
		for (int i = 0; i < pos; i++) {
			p = p.next;
		}
		return p;
	}
	
	public void delete(int pos) throws Exception {
		if (pos < 0 || pos > size()) {
			throw new Exception("下标异常。");
		}
		Node p = head;
		if (pos == 0) {
			head = head.next;
			p.data = null;
			p.next = null;
		}
		for (int i = 0; i < pos - 1; i++) {
			p = p.next;
		}
		Node n = p.next;
		p.next = p.next.next;
		n.data = null;
		n.next = null;
	}
	
	public static void main(String[] args) throws Exception {
		MyList list = new MyList();
		list.insert(12, 0);
		list.insert(32, 1);
		list.insert(6, 2);
		list.insert(42, 3);
		list.insert(68, 4);
		list.travel();
	}
}
