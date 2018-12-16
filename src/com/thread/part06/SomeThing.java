package com.thread.part06;

public enum SomeThing {

	INSTANCE;
	private Resource instance;
	SomeThing() {
		instance = new Resource();
	}
	
	public Resource getInstance() {
		return instance;
	}
}
