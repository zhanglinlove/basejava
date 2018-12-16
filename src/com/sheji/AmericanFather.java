package com.sheji;

public class AmericanFather implements IFather{

	private String name;
	public AmericanFather(String name) {
		this.name = name;
		System.out.println("create a us father.");
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
