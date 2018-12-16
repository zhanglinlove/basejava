package com.sheji;

public class ChineseFather implements IFather{

	private String name;
	public ChineseFather(String name) {
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
