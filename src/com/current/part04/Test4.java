package com.current.part04;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test4 {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		List<Task2> list = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			Task2 t = new Task2(i + "");
			list.add(t);
		}
		List<Future<Result>> resultList = null;
		try {
			resultList = executor.invokeAll(list);
		} catch(InterruptedException e) {
			
		}
		executor.shutdown();
		System.out.println("print result :");
		for (int i = 0; i < resultList.size(); i++) {
			Future<Result> f = resultList.get(i);
			try {
				Result resu = f.get();
				System.out.println("name=" + resu.getName() + ";value=" + resu.getValue());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
