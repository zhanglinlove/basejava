package com.sheji;

public class AmericanMother implements IMother{

	private String name;
	public AmericanMother(String name) {
		this.name = name;
		System.out.println("create a us mother.");
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
