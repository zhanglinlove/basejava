package com.current.part05;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Test4 {

	public static void main(String[] args) throws IOException {
		final int COUNT_BITS = Integer.SIZE - 3;
		final int RUNNING    = -1 << COUNT_BITS;
		System.out.println(RUNNING);
		int t = ctlOf(RUNNING, 0);
		System.out.println(t);
	}
	
	static int ctlOf(int rs, int wc) { return rs | wc; }
}
