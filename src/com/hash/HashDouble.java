package com.hash;

public class HashDouble {

	private DataItem[] hashArray;
	private int arraySize;
	private DataItem nonItem;
	
	public HashDouble(int size) {
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
				System.out.println("**");
			}
		}
		System.out.println("");
	}
	
	public int hasFunc1(int key) {
		return key % arraySize;
	}
	
	public int hasFunc2(int key) {
		return 5 * (key % 5);
	}
	
	public void insert(DataItem data) {
		int key = data.getKey();
		int hashValue = hasFunc1(key);
		int stepSize = hasFunc2(key);
		while (hashArray[hashValue] != null &&
				hashArray[hashValue].getKey() != -1) {
			hashValue += stepSize;
			hashValue %= arraySize;
		}
		hashArray[hashValue] = data;
	}
	
	public DataItem delete(int key) {
		int hashValue = hasFunc1(key);
		int stepSize = hasFunc2(key);
		while (hashArray[hashValue] != null) {
			if (hashArray[hashValue].getKey() == key) {
				DataItem item = hashArray[hashValue];
				hashArray[hashValue] = nonItem;
				return item;
			}
			hashValue += stepSize;
			hashValue %= arraySize;
		}
		return null;
	}
	
	public DataItem find(int key) {
		int hashValue = hasFunc1(key);
		int stepSize = hasFunc2(key);
		while (hashArray[hashValue] != null) {
			if (hashArray[hashValue].getKey() == key) {
				return hashArray[hashValue];
			}
			hashValue += stepSize;
			hashValue %= arraySize;
		}
		return null;
	}
}
