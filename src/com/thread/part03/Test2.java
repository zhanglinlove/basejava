package com.thread.part03;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class Test2 {

	public static void main(String[] args) {
		WriteData w = new WriteData();
		ReadData r = new ReadData();
		
		PipedWriter write = new PipedWriter();
		PipedReader read = new PipedReader();
		
		Thread t1 = new Thread1(w, write);
		Thread t2 = new Thread2(r, read);
		
		try {
			write.connect(read);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t1.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();
	}
}
