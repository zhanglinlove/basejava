package com.struct;

public class StackApp {

	public static void main(String[] args) throws Exception {
		StackX stack = new StackX(10);
		stack.push(10);
		stack.push(22);
		stack.push(-1);
		stack.push(43);
		stack.push(73);
		stack.push(21);
		stack.push(41);
		stack.push(9);
		stack.push(32);
		stack.push(76);
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + "  ");
		}
	}
}
