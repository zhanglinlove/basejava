package com.hash;

public class HasTableLink {

	private SortList[] hashArray;
	private int arraySize;
	
	public HasTableLink(int size) {
		arraySize = size;
		hashArray = new SortList[arraySize];
		for (int i = 0; i < arraySize; i++) {
			hashArray[i] = new SortList();
		}
	}
	
	public void display() {
		for (int i = 0; i < hashArray.length; i++) {
			System.out.println(i + ". ");
			hashArray[i].display();
		}
	}
	
	public int hasFunc(int key) {
		return key % arraySize;
	}
	
	public void insert(Link theLink) {
		int key = theLink.getKey();
		int hasValue = hasFunc(key);
		hashArray[hasValue].insert(theLink);
	}
	
	public void delete(int key) {
		int hasValue = hasFunc(key);
		hashArray[hasValue].delete(key);
	}
	
	public Link find(int key) {
		int hasValue = hasFunc(key);
		return hashArray[hasValue].find(key);
	}
}
