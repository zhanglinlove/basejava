package com.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HashChainApp {

	public static void main(String[] args) {
		Link aDataItem;
		int aKey, size, n, keysPerCell = 100;
		System.out.println("enter hash table size:");
		size = getInt();
		System.out.println("enter intial number of items ");
		n = getInt();
		HasTableLink table = new HasTableLink(size);
		for (int i = 0; i < n; i++) {
			aKey = (int) (Math.random() * keysPerCell * size);
			aDataItem = new Link(aKey);
			table.insert(aDataItem);
		}
		while (true) {
			System.out.println("enter first char:");
			char choise = getChar();
			switch (choise) {
				case 's':
					table.display();
					break;
				case 'i':
					System.out.println("insert key to table:");
					aKey = getInt();
					aDataItem = new Link(aKey);
					table.insert(aDataItem);
					break;
				case 'd':
					System.out.println("enter key value to delete:");
					aKey = getInt();
					table.delete(aKey);
					break;
				case 'f':
					System.out.println("enter key value to find:");
					aKey = getInt();
					aDataItem = table.find(aKey);
					if (aDataItem != null) {
						System.out.println("find " + aKey);
					} else {
						System.out.println("not found " + aKey);
					}
					break;
				default :
					System.out.println("invalid entry.");
			}
		}
		
	}
	
	public static String getString() throws IOException {
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader buff = new BufferedReader(input);
		return buff.readLine();
	}
	
	public static int getInt() {
		try {
			String str = getString();
			if (str != null && !"".equals(str)) {
				return Integer.valueOf(str);
			}
			return 0;
		} catch (IOException e) {
			e.printStackTrace();
			return 0;
		}
		
	}
	
	public static char getChar() {
		try {
			String str = getString();
			return str.charAt(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
