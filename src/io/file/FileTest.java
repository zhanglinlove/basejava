package io.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;
import java.util.List;
/**
 * File的用法，将文件读取到list中。
 * @author zhanglin
 *
 */
public class FileTest {

	public static void main(String[] args) throws FileNotFoundException {
		String path = System.getProperty("user.dir") + File.separator + "config"
					+ File.separator + "a.txt";
		Path p = new File(path).toPath();
		try {
			List<String> list = Files.readAllLines(p);
			Iterator<String> i = list.iterator();
			while (i.hasNext()) {
				System.out.println(i.next());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		/**
		 * 写入数据到文件中去。
		 */
		try {
			Files.write(p, "\nsex=man".getBytes("UTF-8"), StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
