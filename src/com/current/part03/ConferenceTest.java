package com.current.part03;

public class ConferenceTest {

	public static void main(String[] args) {
		Videoconference conference = new Videoconference(10);
		
		Thread t = new Thread(conference);
		t.start();
		
		for (int i = 0; i < 10; i++) {
			Participant p = new Participant(conference, "Participant-" + i);
			Thread ts = new Thread(p);
			ts.start();
		}
	}
}
