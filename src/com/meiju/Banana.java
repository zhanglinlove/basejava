package com.meiju;

public enum Banana {

	APPLE("apple", 12),ORANGE("orange", 11),WATER("water", 3);
	
	private String name;
	private int num;
	
	private Banana(String name, int num) {
		this.name = name;
		this.num = num;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name + "_" + num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
}
