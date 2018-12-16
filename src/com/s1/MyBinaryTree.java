package com.s1;

public class MyBinaryTree<T extends Comparable<T>> {

	private TreeNode<T> root;
	
	class TreeNode<T extends Comparable<T>> {
		T value;
		TreeNode left;
		TreeNode right;
		TreeNode parent;
		
		public TreeNode(TreeNode left, TreeNode right, TreeNode parent, T value) {
			this.value = value;
			this.left = left;
			this.right = right;
			this.parent = parent;
		}
	}
	
	public void insert(T value) {
		TreeNode<T> node = new TreeNode<T>(null, null, null, value);
		insert(node);
	}
	
	private void insert(TreeNode<T> node) {
		TreeNode<T> pos = null;
		TreeNode<T> current = this.root;
		while (current != null) {
			pos = current;
			if (current.value.compareTo(node.value) > 0) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		node.parent = pos;
		if (pos == null) {
			this.root = node;
		} else {
			if (pos.value.compareTo(node.value) > 0) {
				pos.left = node;
			} else {
				pos.right = node;
			}
		}
	}
	
	public void remove(T value) {
		TreeNode<T> node = search(this.root, value);
		if (node != null) {
			remove(node);
		}
	}
	
	private void remove(TreeNode<T> node) {
		TreeNode<T> child, parent;
		if (node.left != null && node.right != null) {
			TreeNode<T> replace = node.right;
			while (replace.left != null)
				replace = replace.left;
			child = replace.right;
			parent = replace.parent;
			if (parent.left == replace) {
				parent.left = child;
			} else {
				parent.right = child;
			}
			child.parent = parent;
			node.value = replace.value;
			replace = null;
			return;
		}
		if (node.left != null) {
			child = node.left;
		} else {
			child = node.right;
		}
		parent = node.parent;
		
		if (parent == null) {
			this.root = child;
		} else {
			if (parent.left == node) {
				parent.left = child;
			} else {
				parent.right = child;
			}
		}
		if (child != null)
			child.parent = parent;
		node = null;
	}
	
	public TreeNode<T> search(TreeNode<T> node, T value) {
		if (node == null) return null;
		TreeNode<T> next;
		while (node != null) {
			int num = node.value.compareTo(value);
			if (num > 0) {
				node = node.left;
			} else if (num < 0){
				node = node.right;
			} else {
				return node;
			}
		}
		return null;
	}
}
