package com.current.part05;

import java.util.Random;

public class DocumentMock {

	private String words[] = {"the", "hello", "goodbye", "java",
				"thread", "pool", "random", "class", "main"};
	
	public String[][] generateDocument(int numLines, int numWords, String word) {
		int counter = 0;
		String document[][] = new String[numLines][numWords];
		Random random = new Random();
		for (int i = 0; i < numLines; i++) {
			for (int j = 0; j < numWords; j++) {
				int index = random.nextInt(words.length);
				document[i][j] = words[index];
				if (document[i][j].equals(word)) {
					counter++;
				}
			}
		}
		System.out.println("DocumentMock the word appear " + counter + " times in the document.");
		return document;
	}
}
