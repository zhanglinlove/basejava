package com.sheji;

public class Test6 {

	public static void main(String[] args) {
		Composite root = new Composite("服装");
		Composite c1 = new Composite("男装");
		Composite c2 = new Composite("女装");
		
		Leaf l1 = new Leaf("夹克");
		Leaf l2 = new Leaf("西装");
		Leaf l3 = new Leaf("裙子");
		Leaf l4 = new Leaf("套装");
		
		root.add(c1);
		root.add(c2);
		
		c1.add(l1);
		c1.add(l2);
		c1.add(l4);
		c2.add(l3);
		c2.add(l4);
		
		root.printStruct("");
		c1.printStruct("");
		c2.printStruct("");
	}
}
