package com.sheji.mediate;

public class SoundCard extends Colleague{

	public SoundCard(Mediator mediator) {
		super(mediator);
		// TODO Auto-generated constructor stub
	}

	public void soundData(String data) {
		System.out.println("声音：" + data);
	}
}
