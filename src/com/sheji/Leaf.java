package com.sheji;

public class Leaf implements Component{

	private String name;
	
	public Leaf(String name) {
		this.name = name;
	}
	
	@Override
	public void printStruct(String msg) {
		System.out.println(this.name + ":" + msg);
	}

}
