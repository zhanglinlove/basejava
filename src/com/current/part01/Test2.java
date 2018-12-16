package com.current.part01;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Thread.State;

public class Test2 {

	public static void main(String[] args) {
		Thread[] threads = new Thread[10];
		Thread.State[] state = new Thread.State[10];
		for (int i = 0; i < 10; i++) {
			threads[i] = new Thread(new Calculator(i));
			if (i % 2 == 0) {
				threads[i].setPriority(Thread.MAX_PRIORITY);
			} else {
				threads[i].setPriority(Thread.MIN_PRIORITY);
			}
			threads[i].setName("Thread-" + i);
		}
		try {
			FileWriter w = new FileWriter(new File("F:\\log\\t.txt"));
			PrintWriter p = new PrintWriter(w);
			
			for (int i = 0; i < 10; i++) {
				p.println("Main:Status of thread " + i + ":" + threads[i].getState());
				state[i] = threads[i].getState();
				threads[i].start();
			}
			boolean finish = false;
			while (!finish) {
				for (int i = 0; i < 10; i++) {
					if (threads[i].getState() != state[i]) {
						writeThreadInfo(p, threads[i], state[i]);
						state[i] = threads[i].getState();
					}
				}
				finish = true;
				for (int i = 0; i < 10; i++) {
					finish = finish && (threads[i].getState() == State.TERMINATED);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void writeThreadInfo(PrintWriter pw, Thread t, State state) {
		pw.printf("Main: Id %d  - %s\n", t.getId(), t.getName());
		pw.printf("Main: priority %d\n", t.getPriority());
		pw.printf("Main: old State: %s\n", state);
		pw.printf("Main: New state: %s\n", t.getState());
		pw.printf("Main: ******************************\n");
		pw.flush();
	}
}
