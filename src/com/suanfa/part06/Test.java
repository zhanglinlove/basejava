package com.suanfa.part06;

import java.util.Random;

/**
 * 随机数。
 * @author zhanglin
 *
 */
public class Test {

	public static void main(String[] args) {
		double m, n;
		
		m = 10.0;
		n = 20.0;
		Random rand = new Random();
		double s = rand.nextInt(8) + rand.nextFloat();
		double[] r = {s};
		System.out.println("产生10.0至20.0的随机数。");
		for (int j = 0; j < 10; j++) {
			System.out.printf("%10.5f\n", m + (n - m) * rand(r));
		}
	}
	
	public static double rand(double[] r) {
		double base, u, v, p, temp1, temp2, temp3;
		base = 256.0;
		u = 17.0;
		v = 139.0;
		temp1 = u * (r[0]) + 1;
		temp2 = (int)(temp1 / base);
		temp3 = temp1 - temp2 * base;
		r[0] = temp3;
		p = r[0] / base;
		return p;
	}
}
