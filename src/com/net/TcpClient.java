package com.net;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 8000);
			OutputStream output = socket.getOutputStream();
			InputStream input = socket.getInputStream();
			System.out.println("----send message----");
			BufferedOutputStream bs = new BufferedOutputStream(output);
			PrintWriter writ = new PrintWriter(bs, true);
			writ.println("come to see server...");
			writ.flush();
			BufferedInputStream bis = new BufferedInputStream(input);
			int len;
			byte[] b = new byte[1024];
			len = bis.read(b);
			String str = new String(b);
			System.out.println("server return:" + str);
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
