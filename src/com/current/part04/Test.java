package com.current.part04;

public class Test {

	public static void main(String[] args) {
		Server server = new Server();
		for (int i = 0; i < 60; i++) {
			Task task = new Task("task " + i);
			server.executeTask(task);
		}
		server.endServer();
	}
}
