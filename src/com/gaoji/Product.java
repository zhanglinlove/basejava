package com.gaoji;

import java.util.HashSet;
import java.util.Set;

public class Product {

	private String name;
	private double price;
	private Set<ObServer> set;

	public Product(String name, double price) {
		super();
		this.name = name;
		this.price = price;
		this.set = new HashSet<ObServer>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		if (this.price != price) {
			this.price = price;
			notifyObServer();
		} else {
			this.price = price;
		}
	}

	public Set<ObServer> getSet() {
		return set;
	}

	public void setSet(Set<ObServer> set) {
		this.set = set;
	}
	
	public void addObServer(ObServer obj) {
		set.add(obj);
	}
	
	public void notifyObServer() {
		for (ObServer server : set) {
			server.update(this);
		}
	}
}
