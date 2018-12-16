package com.meiju;

public enum Status {

	SAVE(4),VERIFY(5),SUCCESS(2),FAIL(3);
	
	private int num;
	
	private Status(int num) {
		this.num = num;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
}
