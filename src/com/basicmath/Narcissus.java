package com.basicmath;

/**
 * 打印出所有的 水仙花数 ，所谓 水仙花数 是指一个三位数，其
 * 各位数字立方和等于该数本身。例如：153是一个 水仙花数 ，
 * 因为153=1的三次方＋5的三次方＋3的三次方。
 * @author zhanglin
 *
 * @date 2018年5月27日
 */
public class Narcissus {

	public static void main(String[] args) {
		Narcissus n = new Narcissus();
		for (int i = 100; i < 500; i++) {
			if (n.isNarcissus(i)) {
				System.out.println(i + "是水仙花.");
			}
		}
	}
	
	public boolean isNarcissus(int num) {
		
		int x = num / 100;
		int y = (num % 100) / 10;
		int z = num % 10;
		int total = x * x * x + y * y * y + z * z * z;
		if (total == num) return true;
		return false;
	}
}
