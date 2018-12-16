package com.struct;

public class Reverser {

	private String input;
	private String output;
	
	public Reverser(String in) {
		input = in;
	}
	
	public String doRev() throws Exception {
		int max = input.length();
		StackChar stack = new StackChar(max);
		for (int i = 0; i < max; i++) {
			char c = (char)input.charAt(i);
			stack.push(c);
		}
		output = "";
		while (!stack.isEmpty()) {
			char c = stack.pop();
			output = output + c;
		}
		return output;
	}
}
