package com.thread.part03;

public class Test1 {

	public static void main(String[] args) {
		Storage s = new Storage();
		Object lock = new Object();
		Product p1 = new Product(s, lock);
		Product p2 = new Product(s, lock);
		Product p3 = new Product(s, lock);
		Product p4 = new Product(s, lock);
		Product p5 = new Product(s, lock);
		Product p6 = new Product(s, lock);
		Customer c1 = new Customer(s, lock);
		Customer c2 = new Customer(s, lock);
		Customer c3 = new Customer(s, lock);
		new Thread(p1).start();
		new Thread(p2).start();
		new Thread(p3).start();
		new Thread(p4).start();
		new Thread(p5).start();
		new Thread(p6).start();
		new Thread(c1).start();
		new Thread(c2).start();
		new Thread(c3).start();
	}
}
