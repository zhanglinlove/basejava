package com.struct;

public class StackChar {

	private int max;
	private char[] charArray;
	private int top;
	
	public StackChar(int s) {
		max = s;
		charArray = new char[max];
		top = -1;
	}
	
	public void push(char value) throws Exception {
		if (top >= max) {
			throw new Exception("栈已经满了。");
		}
		charArray[++top] = value;
	}
	
	public char pop() throws Exception {
		if (top == -1) {
			throw new Exception("栈已经空了。");
		}
		char value = charArray[top--];
		return value;
	}
	
	public long peek() throws Exception {
		if (top == -1) {
			throw new Exception("栈已经空了。");
		}
		return charArray[top];
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public boolean isFull() {
		return top == max;
	}
}
