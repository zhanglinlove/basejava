package com.current.part05;

import java.util.List;
import java.util.concurrent.RecursiveAction;

public class Task extends RecursiveAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Product> products;
	private int first;
	private int last;
	private double increment;
	
	public Task(List<Product> products, int first, int last, double increment) {
		super();
		this.products = products;
		this.first = first;
		this.last = last;
		this.increment = increment;
	}

	@Override
	protected void compute() {
		// TODO Auto-generated method stub
		if (last - first < 10) {
			updatePrices();
		} else {
			int middle = (first + last) / 2;
			System.out.println("task:" + getQueuedTaskCount());
			Task t1 = new Task(products, first, middle + 1, increment);
			Task t2 = new Task(products, middle + 1, last, increment);
			invokeAll(t1, t2);
		}
	}

	private void updatePrices() {
		for (int i = first; i < last; i++) {
			Product p = products.get(i);
			p.setPrice(p.getPrice() * (1 + increment));
		}
	}
}
