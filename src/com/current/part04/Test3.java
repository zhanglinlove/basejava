package com.current.part04;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test3 {

	public static void main(String[] args) {
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
		List<Future<Integer>> list = new ArrayList<>();
		Random rand = new Random();
		for (int i = 0; i < 10; i++) {
			Integer number = rand.nextInt(9) + 1;
			FactoryCalculator cal = new FactoryCalculator(number);
			Future<Integer> result = executor.submit(cal);
			list.add(result);
		}
		do {
			System.out.println("complete task number:" + executor.getCompletedTaskCount());
			for (int i = 0; i < list.size(); i++) {
				Future<Integer> f = list.get(i);
				System.out.println("task " + i + " " + f.isDone());
			}
			try {
				TimeUnit.MILLISECONDS.sleep(50);
			} catch (InterruptedException e) {
				
			}
		} while (executor.getCompletedTaskCount() < list.size());
		
		for (int i = 0; i < list.size(); i++) {
			Future<Integer> fu = list.get(i);
			Integer num = null;
			try {
				num = fu.get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("task " + i + ":" + num);
		}
		executor.shutdown();
	}
}
