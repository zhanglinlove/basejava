package com.s1;

public class Test {

	public static void main(String[] args) {
		MyCollection collection = new MyCollection();
		Data d1 = new Data("1", "张三", 88, "男");
		collection.insert(d1);
		d1 = new Data("2", "李四", 90, "女");
		collection.insert(d1);
		d1 = new Data("3", "王五", 80, "男");
		collection.insert(d1);
		d1 = new Data("4", "孙琦", 83, "男");
		collection.insert(d1);
		System.out.println(collection.print());
		collection.delete(2);
		System.out.println(collection.print());
	}
}
