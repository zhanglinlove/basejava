package com.tree;

public class BinTree<T extends Comparable<T>> {

	private Node<T> root = null;
	private int size;
	
	public static void main(String[] args) {
		Integer[] arr = {77, 23, 45, 14, -9, 98, 101, 32, 56, 7, 25};
		BinTree tree = new BinTree();
		tree.createTree(arr);
		tree.print();
	}
	
	public void print() {
		preOrder(root);
	}
	
	//后序
	public void afterOrder(Node<T> node) {
		if (node == null) return;
		afterOrder(node.leftNode);
		afterOrder(node.rightNode);
		System.out.println(node.value);
	}
	
	//中序
	public void inOrder(Node<T> node) {
		if (node == null) return;
		inOrder(node.leftNode);
		System.out.println(node.value);
		inOrder(node.rightNode);
	}
	
	//先序
	public void preOrder(Node<T> node) {
		if (node == null) return;
		System.out.println(node.value);
		preOrder(node.leftNode);
		preOrder(node.rightNode);
	}
	
	public void createTree(T[] array) {
		if (array == null || array.length == 0)
			return;
		Node<T> next = null;;
		Node<T> current = null;
		for (T value : array) {
			next = root;
			Node<T> temp = new Node<>(value, null, null, null);
			if (root == null) {
				root = temp;
			} else {
				while (next != null) {
					current = next;
					if (next.value.compareTo(value) < 0) {
						next = next.rightNode;
					} else {
						next = next.leftNode;
					}
				}
				if (current.value.compareTo(value) < 0) {
					current.rightNode = temp;
					
				} else {
					current.leftNode = temp;
				}
				temp.parent = current;
			}
		}
	}
	
	private static class Node<T extends Comparable<T>> {
		T value;
		Node<T> parent;
		Node<T> leftNode;
		Node<T> rightNode;
		
		public Node(T value, Node<T> parent, Node<T> leftNode, Node<T> rightNode) {
			this.value = value;
			this.parent = parent;
			this.leftNode = leftNode;
			this.rightNode = rightNode;
		}
	}
}
