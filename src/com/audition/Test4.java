package com.audition;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;

public class Test4 {

	public static void main(String[] args) throws IOException {
		File file = new File("F:/2");
		RandomAccessFile accessFile = new RandomAccessFile(file, "r");
		long len = accessFile.length();
		long length = len - 1;
		long pos = length;
		while (pos > 0) {
			accessFile.seek(pos);
			byte b = accessFile.readByte();
			if (b == '\n') {
				accessFile.seek(pos + 1);
				break;
			}
			pos--;
		}
		if (pos == 0) accessFile.seek(pos);
		byte[] m = new byte[(int) (length - pos)];
		accessFile.read(m);
		String s = new String(m, Charset.forName("utf-8"));
		System.out.println(s);
		accessFile.close();
	}
}
