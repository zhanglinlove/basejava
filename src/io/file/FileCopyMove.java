package io.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * 文件移动或复制。
 * @author zhanglin
 *
 */
public class FileCopyMove {

	public static void main(String[] args) {
		Path source = Paths.get("F:\\javatest", "1.txt");
		Path destination = Paths.get("F:\\javatest", "copy.txt");
		Path second = Paths.get("F:\\javatest\\exam", "1.txt");
		copyFile(source, destination);
		moveFile(destination, second);
		deleteFile(second);
	}
	
	public static void copyFile(Path source, Path destination) {
		try {
			Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void moveFile(Path source, Path destination) {
		try {
			Files.move(source, destination, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteFile(Path source) {
		try {
			Files.deleteIfExists(source);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
