package com.sheji;

public class Test7 {

	public static void main(String[] args) {
		Branch root = new Branch("服装");
		Branch c1 = new Branch("男装");
		Branch c2 = new Branch("女装");
		
		Leafs l1 = new Leafs("夹克");
		Leafs l2 = new Leafs("西装");
		Leafs l3 = new Leafs("裙子");
		Leafs l4 = new Leafs("套装");
		
		root.add(c1);
		root.add(c2);
		
		c1.add(l1);
		c1.add(l2);
		c1.add(l4);
		c2.add(l3);
		c2.add(l4);
		
		root.printStruct("");
		System.out.println("---------------");
		c1.printStruct("");
		System.out.println("---------------");
		c2.printStruct("");
	}
}
