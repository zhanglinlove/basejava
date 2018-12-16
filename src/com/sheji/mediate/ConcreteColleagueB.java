package com.sheji.mediate;

public class ConcreteColleagueB extends Colleague{

	public ConcreteColleagueB(Mediator mediator) {
		super(mediator);
		
	}
	
	public void operation() {
		getMediator().change(this);
	}
}
