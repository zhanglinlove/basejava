package com.sheji.mediate;

public class CPU extends Colleague{

	private String videoData;
	private String soundData;
	
	public CPU(Mediator mediator) {
		super(mediator);
		// TODO Auto-generated constructor stub
	}

	public String getVideoData() {
		return videoData;
	}

	public String getSoundData() {
		return soundData;
	}

	public void executeData(String data) {
		String[] array = data.split(",");
		videoData = array[0];
		soundData = array[1];
		getMediator().change(this);
	}
}
