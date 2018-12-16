package com.current.part03;

import java.util.concurrent.TimeUnit;

public class Participant implements Runnable{

	private Videoconference conference;
	private String name;
	
	public Participant(Videoconference conference, String name) {
		this.conference = conference;
		this.name = name;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conference.arrive(name);
	}

}
