package com.s1;

public class Data2 {

	String data;
	Data2 next;
	Data2 prev;

	public Data2(String data, Data2 next, Data2 prev) {
		super();
		this.data = data;
		this.next = next;
		this.prev = prev;
	}

	public Data2() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Data2 getPrev() {
		return prev;
	}

	public void setPrev(Data2 prev) {
		this.prev = prev;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Data2 getNext() {
		return next;
	}

	public void setNext(Data2 next) {
		this.next = next;
	}

}
