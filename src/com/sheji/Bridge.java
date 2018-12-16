package com.sheji;

public abstract class Bridge {

	private Change change;
	
	public Change getChange() {
		return change;
	}

	public void setChange(Change change) {
		this.change = change;
	}
	
	public void method() {
		change.method();
	}
	
	public abstract void otherMethod();
}
