package com.thread.part03;

import java.io.IOException;
import java.io.PipedReader;

public class ReadData {

	public void readMethod(PipedReader read) {
		try {
			System.out.println("read:");
			char[] b = new char[30];
			int i = read.read(b);
			while (i != -1) {
				String s = new String(b, 0, i);
				System.out.println(s);
				i = read.read(b);
			}
			read.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
