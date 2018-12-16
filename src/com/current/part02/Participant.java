package com.current.part02;

import java.util.concurrent.TimeUnit;

public class Participant implements Runnable{

	private VideoConference conference;
	private String name;
	
	public Participant(VideoConference conference, String name) {
		this.conference = conference;
		this.name = name;
	}
	
	public void run() {
		long duration = (long) (Math.random() * 10);
		try {
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			
		}
		conference.arrive(name);
	}

}
