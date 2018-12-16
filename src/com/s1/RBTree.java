package com.s1;

public class RBTree<T extends Comparable<T>> {

	private RBNode<T> root;
	private static final boolean RED = false;
	private static final boolean BLACK = true;
	
	class RBNode <T extends Comparable<T>> {
		T value;
		RBNode<T> left;
		RBNode<T> right;
		RBNode<T> parent;
		boolean color;
		
		public RBNode(T value, RBNode<T> left, RBNode<T> right, RBNode<T> parent, boolean color) {
			this.value = value;
			this.left = left;
			this.right = right;
			this.parent = parent;
			this.color = color;
		}
	}
	
	public void insert() {
		
	}
	
	public void insert(T value) {
		if (value == null) return;
		RBNode<T> newValue = new RBNode<T>(value, null, null, null, false);
		RBNode<T> next = null;
		RBNode<T> current = this.root;
		while (current != null) {
			next = current;
			if (current.value.compareTo(value) > 0) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		newValue.parent = next;
		if (next == null) {
			this.root = newValue;
		} else {
			if (next.value.compareTo(value) > 0) {
				next.left = newValue;
			} else {
				next.right = newValue;
			}
		}
		insertFixUp(newValue);
	}
	
	private void insertFixUp(RBNode<T> node) {
		RBNode<T> parent, gparent,uncle;
		while ((parent = parentOf(node)) != null && isRed(parent)) {
			gparent = parentOf(parent);
			if (parent == gparent.left) {
				uncle = gparent.right;
				if (uncle != null && isRed(uncle)) {
					setBlack(uncle);
					setBlack(parent);
					setRed(gparent);
					node = gparent;
					continue;
				}
				if (node == parent.right) {
					leftHand(gparent);
					RBNode<T> temp = parent;
					parent = node;
					node = temp;
				}
				if (node == parent.left) {
					setBlack(parent);
					setRed(gparent);
					rightHand(gparent);
				}
			} else {
				uncle = gparent.left;
				if (uncle != null && isRed(uncle)) {
					setBlack(uncle);
					setBlack(parent);
					setRed(gparent);
					node = gparent;
					continue;
				}
				if (node == parent.left) {
					rightHand(gparent);
					RBNode<T> temp = parent;
					parent = node;
					node = temp;
				}
				setBlack(parent);
				setRed(gparent);
				leftHand(gparent);
			}
		}
		setBlack(node);
	}
	
	public void setRed(RBNode<T> node) {
		node.color = RED;
	}
	
	public void setBlack(RBNode<T> node) {
		node.color = true;
	}
	
	public boolean isBlack(RBNode<T> node) {
		return node.color == BLACK ? true : false;
	}
	
	public boolean isRed(RBNode<T> node) {
		return !isBlack(node);
	}
	
	public RBNode<T> parentOf(RBNode<T> node) {
		return node.parent;
	}
	
	public boolean colorOf(RBNode<T> node) {
		return node.color;
	}
	
	public RBNode<T> search(RBNode<T> node, T value) {
		while (node != null) {
			if (node.value.compareTo(value) == 0) {
				return node;
			} else if (node.value.compareTo(value) > 0) {
				node = node.left;
			} else {
				node = node.right;
			}
		}
		return null;
	}
	
	public void rightHand(RBNode<T> node) {
		RBNode<T> left = node.left;
		node.left = left.right;
		if (left.right != null)
			left.right.parent = node;
		left.parent = node.parent;
		if (node.parent == null) {
			this.root = left;
		} else {
			if (node.parent.left == node) {
				node.parent.left = left;
			} else {
				node.parent.right = left;
			}
		}
		node.parent = left;
		left.right = node;
	}
	
	public void leftHand(RBNode<T> node) {
		RBNode<T> right = node.right;
		node.right = right.left;
		if (right.left != null)
			right.left.parent = node;
		right.parent = node.parent;
		if (node.parent == null) {
			this.root = right;
		} else {
			if (node == node.parent.left) {
				node.parent.left = right;
			} else {
				node.parent.right = right;
			}
		}
		node.parent = right;
		right.left = node;
	}
}
