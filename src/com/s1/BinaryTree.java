package com.s1;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {

	private int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
	private static List<Node> nodeList = null;
	
	private static class Node {
		Node leftChild;
		Node rightChild;
		int data;
		
		Node(int newData) {
			this.leftChild = null;
			this.rightChild = null;
			data = newData;
		}
	}
	
	public void createBinTree() {
		nodeList = new ArrayList<>();
		for (int nodeIndex = 0; nodeIndex < array.length; nodeIndex++) {
			nodeList.add(new Node(array[nodeIndex]));
		}
		for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {
			nodeList.get(parentIndex).leftChild = nodeList.get(parentIndex * 2 + 1);
			nodeList.get(parentIndex).rightChild = nodeList.get(parentIndex * 2 + 2);
		}
		int lastParent = array.length / 2 - 1;
		nodeList.get(lastParent).leftChild = nodeList.get(lastParent * 2 + 1);
	}
}
