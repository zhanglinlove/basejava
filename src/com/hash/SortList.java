package com.hash;

public class SortList {

	private Link first;
	
	public SortList() {
		first = null;
	}
	
	public void insert(Link theLink) {
		
		Link previous = null;
		Link current = first;
		if (current == null) {
			first = current = theLink;
		} else {
			previous = theLink;
			previous.next = current;
			first = previous;
		}
	}
	
	public void delete(int key) {
		Link previous = null;
		Link current = first;
		if (current == null) {
			return;
		}
		if (current.getKey() == key) {
			previous = current.next;
			current.next = null;
			first = previous;
		} else {
			for (previous = current; previous.next != null; previous = previous.next) {
				current = previous.next;
				if (current.getKey() == key) {
					previous.next = current.next;
					current.next = null;
				}
			}
		}
		
	}
	
	public Link find(int key) {
		Link current = first;
		while (current != null) {
			if (current.getKey() == key) {
				return current;
			}
			current = current.next;
		}
		return null;
	}
	
	public void display() {
		System.out.print("first----->last:");
		Link current = first;
		while (current != null) {
			current.display();
			current = current.next;
		}
		System.out.println("");
	}
}
