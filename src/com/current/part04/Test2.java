package com.current.part04;

import java.util.concurrent.Executors;

public class Test2 {

	public static void main(String[] args) {
		Server2 server = new Server2();
		for (int i = 0; i < 20; i++) {
			Task task = new Task("task " + i);
			server.executeTask(task);
		}
		server.endServer();
		
	}
}
