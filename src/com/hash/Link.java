package com.hash;

public class Link {

	private int iData;
	public Link next;
	
	public Link(int i) {
		iData = i;
	}
	
	public int getKey() {
		return iData;
	}
	
	public void display() {
		System.out.print(iData + " ");
	}
}
