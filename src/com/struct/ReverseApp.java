package com.struct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseApp {

	public static void main(String[] args) throws Exception {
		String in, out;
		while (true) {
			System.out.println("enter a string:");
			System.out.flush();
			in = read();
			if ("".equals(in)) {
				break;
			}
			Reverser server = new Reverser(in);
			out = server.doRev();
			System.out.println("reverser:" + out);
		}
	}
	
	public static String read() throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		return read.readLine();
	}
}
