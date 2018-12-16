package com.current.part05;

import java.util.ArrayList;
import java.util.List;

public class ProductListGenerator {

	public List<Product> generator(int size) {
		List<Product> list = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			Product p = new Product();
			p.setName("Product-" + i);
			p.setPrice(10);
			list.add(p);
		}
		return list;
	}
	
	
}
