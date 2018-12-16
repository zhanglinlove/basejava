package com.sheji;

public class Leafs extends Brantch{

	private String name;
	
	public Leafs(String name) {
		this.name = name;
	}
	
	@Override
	public void printStruct(String name) {
		System.out.println(this.name + "-" + name);
	}

}
