package com.tree;

public class Node {

	int iData;
	double fData;
	Node leftChild;
	Node rightChild;
	
	public void displayNode() {
		System.out.print("{");
		System.out.print(iData);
		System.out.print(",");
		System.out.print(fData);
		System.out.print("}");
	}
}
