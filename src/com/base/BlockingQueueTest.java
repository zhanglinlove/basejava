package com.base;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {

	private static final int FILE_QUEUE_SIZE = 10;
	private static final int SEARCH_THREADS = 100;
	private static final File DUMMY = new File("");
	private static BlockingQueue<File> queue = new ArrayBlockingQueue<>(FILE_QUEUE_SIZE);
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter base directory:");
		String directory = in.nextLine();
		System.out.println("Enter keyword:");
		String keyword = in.nextLine();
		
		Runnable enumerator = () -> {
			try {
				enumerate(new File(directory));
				queue.put(DUMMY);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		new Thread(enumerator).start();
		for (int i = 1; i < SEARCH_THREADS; i++) {
			Runnable search = () -> {
				boolean done = false;
				try {
					while (!done) {
						File file = queue.take();
						if (file == DUMMY) {
							queue.put(file);
							done = true;
						} else {
							search(file, keyword);
						}
					}
				} catch (InterruptedException | FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			};
			new Thread(search).start();
		}
	}
	
	public static void enumerate(File directory) throws InterruptedException {
		File[] files = directory.listFiles();
		for(File f : files) {
			if (f.isDirectory()) {
				enumerate(f);
			} else {
				queue.put(f);
			}
		}
	}
	
	public static void search(File file, String keyword) throws FileNotFoundException {
		Scanner sc = new Scanner(file, "utf-8");
		int lineNumber = 0;
		while (sc.hasNext()) {
			lineNumber++;
			String line = sc.nextLine();
			if (line.contains(keyword)) {
				System.out.printf("%s;%d;%s%n", file.getPath(), lineNumber, line);
			}
		}
	}
}
