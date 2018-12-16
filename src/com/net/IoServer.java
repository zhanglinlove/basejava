package com.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class IoServer {

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(10110);
		ExecutorService pool = Executors.newCachedThreadPool();
		System.out.println("服务器启动");
		while (true) {
			final Socket socket = server.accept();
			System.out.println("来了一个新的客户端");
			pool.execute(new Runnable() {
				
				@Override
				public void run() {
					handler(socket);
				}
			});
			
		}
	}
	
	public static void handler(Socket socket) {
		
		try {
			byte[] b = new byte[1024];
			InputStream input = socket.getInputStream();
			while (true) {
				int len = input.read(b);
				if (len != -1) {
					System.out.println(new String(b, 0, len));
				} else {
					break;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("socket 关闭");
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
