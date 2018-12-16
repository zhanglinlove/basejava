package com.sheji.mediate;

public class VedioCard extends Colleague{

	public VedioCard(Mediator mediator) {
		super(mediator);
		// TODO Auto-generated constructor stub
	}

	public void showData(String data) {
		System.out.println("你现在看的是" + data);
	}
}
