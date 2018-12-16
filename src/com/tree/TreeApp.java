package com.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TreeApp {

	public static void main(String[] args) {
		int value;
		Tree tree = new Tree();
		tree.insert(50, 1.5);
		tree.insert(25, 1.7);
		tree.insert(75, 1.9);
		tree.insert(12, 1.5);
		tree.insert(37, 1.2);
		tree.insert(43, 1.7);
		tree.insert(30, 1.5);
		tree.insert(33, 1.2);
		tree.insert(87, 1.7);
		tree.insert(93, 1.5);
		tree.insert(97, 1.5);
		
		while (true) {
			System.out.print("enter first letter of show, ");
			System.out.print("insert,find,delete or tranverse:");
			int choice = getChar();
			switch (choice) {
				case 's' :
					tree.displayTree();
					break;
				case 'i':
					System.out.print("enter value to insert:");
					value = getInt();
					tree.insert(value, value + 0.9);
					break;
				case 'f':
					System.out.print("enter value to find:");
					value = getInt();
					Node node = tree.find(value);
					if (node != null) {
						System.out.print("found:");
						node.displayNode();
						System.out.println();
					} else {
						System.out.println("Could not find " + value);
					}
					break;
				case 'd':
					System.out.print("enter value to delete:");
					value = getInt();
					boolean delete = tree.delete(value);
					if (delete) {
						System.out.println("delete " + value);
					} else {
						System.out.println("Could not delete " + value);
					}
					break;
				case 't':
					System.out.print("enter type 1 ,2 or 3:");
					value = getInt();
					tree.tranverse(value);
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
