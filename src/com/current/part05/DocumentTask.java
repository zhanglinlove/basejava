package com.current.part05;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveTask;

public class DocumentTask extends RecursiveTask<Integer>{

	private String document[][];
	private int start, end;
	private String word;
	
	public DocumentTask(String document[][], int start, int end, String word) {
		this.document = document;
		this.start = start;
		this.end = end;
		this.word = word;
	}
	
	@Override
	protected Integer compute() {
		// TODO Auto-generated method stub
		Integer result = null;
		if (end - start < 100) {
			result = processLines(document, start, end, word);
		} else {
			int mid = (start + end) / 2;
			DocumentTask t1 = new DocumentTask(document, start, mid, word);
			DocumentTask t2 = new DocumentTask(document, mid, end, word);
			invokeAll(t1, t2);
			try {
				result = groupResults(t1.get(), t2.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	private Integer processLines(String document[][], int start, int end, String word) {
		List<LineTask> tasks = new ArrayList<>();
		for (int i = start; i < end; i++) {
			LineTask task = new LineTask(document[i], start, end, word);
			tasks.add(task);
		}
		invokeAll(tasks);
		int result = 0;
		for (int i = 0; i < tasks.size(); i++) {
			LineTask task = tasks.get(i);
			try {
				result += task.get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return new Integer(result);
	}
	
	private Integer groupResults(Integer num1, Integer num2) {
		Integer result;
		result = num1 + num2;
		return result;
	}
}
