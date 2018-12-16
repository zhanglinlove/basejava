package com.thread.part03;

import java.io.IOException;
import java.io.PipedWriter;

public class WriteData {

	public void writeMethod(PipedWriter write) {
		try {
			System.out.println("write:");
			for (int i = 0; i < 100; i++) {
				String data = "" + (i + 1);
				write.write(data);
				System.out.print(data + " ");
			}
			System.out.println();
			write.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
