package com.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ThreadEchoHandler implements Runnable{

	private Socket socket;
	public ThreadEchoHandler(Socket socket) {
		this.socket = socket;
	}
	
	public void run() {
		try {
			InputStream input = socket.getInputStream();
			OutputStream output = socket.getOutputStream();
			PrintWriter writ = new PrintWriter(output);
			Scanner sc = new Scanner(input);
			boolean flag = false;
			while (!flag && sc.hasNext()) {
				if ("bye".equals(sc.nextLine())) {
					flag = true;
					continue;
				}
				System.out.println(sc.nextLine());
			}
			writ.println("hello, test socket...");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
