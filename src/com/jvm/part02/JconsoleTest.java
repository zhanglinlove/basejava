package com.jvm.part02;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class JconsoleTest {

	private byte[] b = new byte[30 * 1024];
	public static void main(String[] args) {
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fill(60);
	}

	private static void fill(int n) {
		List<JconsoleTest> list = new ArrayList<>();
		for (int j = 0; j < n; j++) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list.add(new JconsoleTest());
		}
	}
}
