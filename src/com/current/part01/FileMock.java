package com.current.part01;

public class FileMock {

	private String[] content;
	private int index;
	
	public FileMock(int size, int length) {
		content = new String[size];
		StringBuilder sb = null;
		for (int i = 0; i < size; i++) {
			sb = new StringBuilder();
			for (int j = 0; j < length; j++) {
				int k = (int) (Math.random() * 255);
				sb.append((char) k);
			}
			content[i] = sb.toString();
		}
		index = 0;
	}
	
	public boolean hasMoreLine() {
		return index < content.length;
	}
	
	public String getLine() {
		if (this.hasMoreLine()) {
			System.out.println("Mock:" + (content.length - index));
			return content[index++];
		}
		return null;
	}
}
