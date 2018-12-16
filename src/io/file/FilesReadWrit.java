package io.file;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * 用于处理较大的文本。
 * @author zhanglin
 *
 */
public class FilesReadWrit {

	public static void main(String[] args) {
		Path path = FileSystems.getDefault().getPath("F:\\", "Hello.java");
		readByte(path);
	}
	
	public static void readByte(Path path) {
		try {
			InputStream input = Files.newInputStream(path);
			StringBuffer buff = new StringBuffer();
			BufferedInputStream inputStream = new BufferedInputStream(input);
			byte[] b = new byte[1024];
			int len = 0 ;
			while ((len = inputStream.read(b, 0, 1024)) != -1) {
				buff.append(new String(b));
			}
			System.out.println(buff.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void writeByte(Path path) {
		
	}
	
	public static void readCharactor(Path path) {
		
	}
	
	public static void writeCharactor(Path path) {
		
	}
}
