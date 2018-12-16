package com.struct;

public class StackX {

	private int max;
	private long[] stackArray;
	private int top;
	
	public StackX(int s) {
		max = s;
		stackArray = new long[max];
		top = -1;
	}
	
	public void push(long value) throws Exception {
		if (top >= max) {
			throw new Exception("栈已经满了。");
		}
		stackArray[++top] = value;
	}
	
	public long pop() throws Exception {
		if (top == -1) {
			throw new Exception("栈已经空了。");
		}
		long value = stackArray[top--];
		return value;
	}
	
	public long peek() throws Exception {
		if (top == -1) {
			throw new Exception("栈已经空了。");
		}
		return stackArray[top];
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public boolean isFull() {
		return top == max;
	}
}
