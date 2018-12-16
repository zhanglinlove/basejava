package com.net;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * 网络传输中
 * read()只有在连接断开后才会返回 -1. 没有断开是返回不了-1的。
 * @author zhanglin
 *
 */
public class TcpServer {

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(8000);
			Socket socket = server.accept();
			System.out.println("--------start---");
			InputStream input = socket.getInputStream();
			OutputStream output = socket.getOutputStream();
			PrintWriter writ = new PrintWriter(output, true);
			BufferedInputStream buff = new BufferedInputStream(input);
			int len;
			byte[] b = new byte[1024];
			len = buff.read(b);
			String str = new String(b);
			System.out.println("client:" + str);
			writ.println("welcom to visit server.");
			socket.close();
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
