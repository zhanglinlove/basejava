package com.s1;

public class Data {

	String no;
	String name;
	double score;
	String sex;
	
	public Data() {
		super();
	}

	public Data(String no, String name, double score, String sex) {
		super();
		this.no = no;
		this.name = name;
		this.score = score;
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Data [no=" + no + ", name=" + name + ", score=" + score + ", sex=" + sex + "]";
	}
	
}
