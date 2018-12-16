package io.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreateFiles {

	public static void main(String[] args) {
		Path path = Paths.get("F:\\javatest", "path");
		Path source = Paths.get("F:\\javatest", "1.txt");
		createDirectory(path);
		getSize(source);
	}
	
	public static void createDirectory(Path path) {
		try {
			Files.createDirectory(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void getSize(Path path) {
		try {
			boolean f = Files.exists(path);
			
			long l = Files.size(path);
			System.out.println("file is " + f + ";size=" + l);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
