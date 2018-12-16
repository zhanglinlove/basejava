package com.hash;

public class HashTable {

	private DataItem[] hashArray;
	private int arraySize;
	private DataItem nonItem;
	
	public HashTable(int size) {
		arraySize = size;
		hashArray = new DataItem[arraySize];
		nonItem = new DataItem(-1);
	}
	
	public void displayTable() {
		System.out.println("Table:");
		for (int i = 0; i < arraySize; i++) {
			if (hashArray[i] != null) {
				System.out.print(hashArray[i].getKey() + " ");
			} else {
				System.out.print("**");
			}
		}
		System.out.println("");
	}
	
	public int hasFunc(int key) {
		return key % arraySize;
	}
	
	public void insert(DataItem data) {
		int key = data.getKey();
		int hashValue = hasFunc(key);
		while (hashArray[hashValue] != null &&
				hashArray[hashValue].getKey() != -1) {
			++hashValue;
			hashValue %= arraySize;
		}
		hashArray[hashValue] = data;
	}
	
	public DataItem delete(int key) {
		int hashValue = hasFunc(key);
		while (hashArray[hashValue] != null) {
			if (hashArray[hashValue].getKey() == key) {
				DataItem item = hashArray[hashValue];
				hashArray[hashValue] = nonItem;
				return item;
			}
			++hashValue;
			hashValue %= arraySize;
		}
		return null;
	}
	
	public DataItem find(int key) {
		int hashValue = hasFunc(key);
		while (hashArray[hashValue] != null) {
			if (hashArray[hashValue].getKey() == key) {
				return hashArray[hashValue];
			}
			++hashValue;
			hashValue %= arraySize;
		}
		return null;
	}
}
