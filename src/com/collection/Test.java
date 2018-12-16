package com.collection;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.WeakHashMap;
import java.util.concurrent.ArrayBlockingQueue;

public class Test {

	public static void main(String[] args) throws FileNotFoundException {
		HashMap map = new HashMap<>();
		ArrayBlockingQueue queue = new ArrayBlockingQueue<>(10);
		WeakHashMap<String, Integer> weakMap = new WeakHashMap<String, Integer>();
		FileInputStream file = new FileInputStream("");
		BufferedInputStream bf = new BufferedInputStream(file);
		BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(""));
		ArrayList list = new ArrayList<>();
		LinkedList link = new LinkedList<>();
		HashSet set = new HashSet<>();
	}
}
