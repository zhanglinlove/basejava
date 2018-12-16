package com.current.part02;

public class Test3 {

	public static void main(String[] args) {
		VideoConference conference = new VideoConference(10);
		Thread t = new Thread(conference);
		t.start();
		Thread[] threads = new Thread[10];
		for (int i = 0; i < 10; i++) {
			threads[i] = new Thread(new Participant(conference, "participant" + i));
			threads[i].start();
		}
	}
}
