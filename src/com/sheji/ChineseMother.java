package com.sheji;

public class ChineseMother implements IMother{

	private String name;
	public ChineseMother(String name) {
		this.name = name;
		System.out.println("create a cn mother.");
	}
	@Override
	public void printName() {
		System.out.println(this.getClass().getName() + ";" + name);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
