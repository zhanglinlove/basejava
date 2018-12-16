package com.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadEchoServer {

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(8200);
			while (true) {
				Socket socket = server.accept();
				Runnable runable = new ThreadEchoHandler(socket);
				Thread thread = new Thread(runable);
				thread.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
