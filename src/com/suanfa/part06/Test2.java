package com.suanfa.part06;

import java.util.Random;

public class Test2 {

	public static void main(String[] args) {
		Random rand = new Random();
		for (int i = 0; i < 20; i++) {
			System.out.println(rand.nextFloat());
		}
	}
}
