package com.tree;

import java.util.Stack;

public class Tree {

	private Node root;
	
	public Tree() {
		root = null;
	}
	
	public Node find(int key) {
		Node current = root;
		while (current.iData != key) {
			if (current.iData < key) {
				current = current.rightChild;
			} else {
				current = current.leftChild;
			}
			if (current == null) {
				return null;
			}
		}
		return current;
	}
	
	public void insert(int id, double dd) {
		Node node = new Node();
		node.iData = id;
		node.fData = dd;
		Node current = root;
		if (current == null) {
			root = node;
		} else {
			Node parent;
			while (true) {
				parent = current;
				if (current.iData < id) {
					current = current.rightChild;
					if (current == null) {
						parent.rightChild = node;
						return;
					}
				} else {
					current = current.leftChild;
					if (current == null) {
						parent.leftChild = node;
						return;
					}
				}
			}
		}
	}
	
	public boolean delete(int key) {
		Node current = root;
		Node parent = root;
		if (current == null) {
			return false;
		}
		boolean isLeftChild = true;
		while (current.iData != key) {
			parent = current;
			if (key < current.iData) {
				current = current.leftChild;
				isLeftChild = true;
			} else {
				current = current.rightChild;
				isLeftChild = false;
			}
			if (current == null) {
				return false;
			}
		}
		//如果没有删除的节点没有左子树
		if (current.leftChild == null &&
				current.rightChild == null) {
			if (current == root) {
				root = null;
			} else if (isLeftChild) {
				parent.leftChild = null;
			} else {
				parent.rightChild = null;
			}
		} else if (current.rightChild == null) {
			if (current == root) {
				root = current.leftChild;
			} else if (isLeftChild){
				parent.leftChild = current.leftChild;
			} else {
				parent.rightChild = current.leftChild;
			}
		} else if (current.leftChild == null){
			if (current == root) {
				root = current.rightChild;
			} else if (isLeftChild) {
				parent.leftChild = current.rightChild;
			} else {
				parent.rightChild = current.rightChild;
			}
		} else {
			Node node = getSuccessor(current);
			if (current == root) {
				root = node;
			} else if (isLeftChild) {
				parent.leftChild = node;
			} else {
				parent.rightChild = node;
			}
			node.leftChild = current.leftChild;
		}
		return true;
	}
	
	private Node getSuccessor(Node delNode) {
		Node successorParent = delNode;
		Node successor = delNode;
		Node current = delNode.rightChild;
		while (current != null) {
			successorParent = successor;
			successor = current;
			current = current.leftChild;
		}
		if (successor != delNode.rightChild) {
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = delNode.rightChild;
		}
		return successor;
	}
	
	public Node getMinNum() {
		Node current, last;
		if (root == null) {
			return null;
		}
		current = root;
		while (true) {
			last = current;
			current = current.leftChild;
			if (current == null) {
				return last;
			}
		}
	}
	
	public Node getMaxNum() {
		Node current, last;
		if (root == null) {
			return null;
		}
		current = root;
		while (true) {
			last = current;
			current = current.rightChild;
			if (current == null) {
				return last;
			}
		}
	}
	
	public void tranverse(int type) {
		switch (type) {
			case 1:
				System.out.println("PreOrder tranverse:");
				preOrder(root);
				break;
			case 2:
				System.out.println("PreOrder tranverse:");
				inOrder(root);
				break;
			case 3:
				System.out.println("PreOrder tranverse:");
				postOrder(root);
				break;
		}
		System.out.println();
	}
	
	private void preOrder(Node localRoot) {
		if (localRoot != null) {
			System.out.print(localRoot.iData + " ");
			preOrder(localRoot.leftChild);
			preOrder(localRoot.rightChild);
		}
	}
	
	private void inOrder(Node localRoot) {
		if (localRoot != null) {
			inOrder(localRoot.leftChild);
			System.out.print(localRoot.iData + " ");
			inOrder(localRoot.rightChild);
		}
	}
	
	private void postOrder(Node localRoot) {
		if (localRoot != null) {
			postOrder(localRoot.leftChild);
			postOrder(localRoot.rightChild);
			System.out.print(localRoot.iData + " ");
		}
	}
	
	public void displayTree() {
		Stack<Object> globalStack = new Stack<Object>();
		globalStack.push(root);
		int nBlank = 32;
		boolean isRowEmpty = false;
		System.out.println("--------------------------");
		while (isRowEmpty == false) {
			Stack<Object> localStack = new Stack<Object>();
			isRowEmpty = true;
			for (int i = 0; i < nBlank; i++) {
				System.out.println(" ");
			}
			while (globalStack.isEmpty() == false) {
				Node temp = (Node) globalStack.pop();
				if (temp != null) {
					System.out.print(temp.iData);
					localStack.push(temp.leftChild);
					localStack.push(temp.rightChild);
					if (temp.leftChild != null &&
							temp.rightChild != null) {
						isRowEmpty = false;
					}
				} else {
					System.out.print("--");
					localStack.push(null);
					localStack.push(null);
				}
			}
			System.out.println();
			nBlank /= 2;
			while (localStack.isEmpty() == false) {
				globalStack.push(localStack.pop());
			}
		}
		System.out.println("--------------------------");
	}
}
