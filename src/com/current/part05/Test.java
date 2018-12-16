package com.current.part05;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class Test {

	public static void main(String[] args) {
		ProductListGenerator generator = new ProductListGenerator();
		List<Product> products = generator.generator(10000);
		Task t = new Task(products, 0, products.size(), 0.20);
		ForkJoinPool pool = new ForkJoinPool();
		pool.execute(t);
		do {
			try {
				System.out.println("thread steal:" + pool.getStealCount());
				System.out.println("parallelism:" + pool.getParallelism());
				TimeUnit.MILLISECONDS.sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while (!t.isDone());
		pool.shutdown();
		if (t.isCompletedNormally()) {
			System.out.println("process has complete normally.");
		}
		for (int i = 0; i < products.size(); i++) {
			Product p = products.get(i);
			if (p.getPrice() != 12) {
				System.out.println("product:" + p.getName() + ";price=" + p.getPrice());
			}
		}
		System.out.println("end of program.");
	}
}
