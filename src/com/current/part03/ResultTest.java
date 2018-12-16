package com.current.part03;

import java.util.concurrent.CyclicBarrier;
/**
 * CyclicBarrier同步
 * @author zhanglin
 *
 */
public class ResultTest {

	public static void main(String[] args) {
		int rows = 10000;
		int number = 1000;
		int search = 5;
		int participants = 5;
		int lines_participants = 5;
		MatrixMock mock = new MatrixMock(rows, number, search);
		Results results = new Results(rows);
		Grouper group = new Grouper(results);
		CyclicBarrier barrier = new CyclicBarrier(participants, group);
		
		Searcher searchers[] = new Searcher[participants];
		for (int i = 0; i < participants; i++) {
			searchers[i] = new Searcher(i * lines_participants, 
					i * lines_participants + i * lines_participants, mock, results, 5, barrier);
			Thread t = new Thread(searchers[i]);
			t.start();
		}
		System.out.println("the main thread has finished.");
	}
}
