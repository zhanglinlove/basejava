package com.base;

public class RBTree<T extends Comparable<T>> {

	private RBTree<T> root;
	private static final boolean RED = false;
	private static final boolean BLACK = true;

	class RBNode<T extends Comparable<T>> {
		boolean color;
		T key;
		RBNode<T> left;
		RBNode<T> right;
		RBNode<T> parent;
		
		public RBNode(boolean color, T key, RBNode<T> left, RBNode<T> right,
				RBNode<T> parent) {
			super();
			this.color = color;
			this.key = key;
			this.left = left;
			this.right = right;
			this.parent = parent;
		}
		
		public T getKey() {
			return key;
		}

		@Override
		public String toString() {
			return "RBNode [color=" + color + ", key=" + key + ", left=" + left + ", right=" + right + ", parent="
					+ parent + "]";
		}
		
	}

	public RBTree(RBTree<T> root) {
		super();
		this.root = null;
	}
	
	public RBNode<T> getParent(RBNode<T> node) {
		return node == null ? null : node.parent;
	}
	
	public void setParent(RBNode<T> node, RBNode<T> parent) {
		if (node != null) {
			node.parent = parent;
		}
	}
	
	public boolean getColor(RBNode<T> node) {
		return node != null ? node.color :BLACK;
	}
	
	public boolean isRed(RBNode<T> node) {
		return (node != null) && (node.color == RED) ? true : false; 
	}
	
	public boolean isBlack(RBNode<T> node) {
		return !isRed(node);
	}
	
	public void setRed(RBNode<T> node) {
		if (node != null) {
			node.color = RED;
		}
	}
	
	public void setBlack(RBNode<T> node) {  
		if (node != null) {
			node.color = BLACK;
		}
	}
	
	/**
	 * 前序遍历
	 */
	public void preOrder(RBNode<T> tree) {
		if (tree != null) {
			System.out.println("key=" + tree.key);
			preOrder(tree.left);
			preOrder(tree.right);
		}
	}
}
