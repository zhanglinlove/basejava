package com.basicmath;

/**
 * 有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子
 * 长到第三个月后每个月又生一对兔子，假如兔子都不死，问每个月
 * 的兔子总数为多少？
 * 第一个月：1
 * 第二个月：1
 * 第三个月：2
 * 第四个月：3
 * 第五个月：5
 * 第六个月：8
 * 第七个月：13
 * f(n) = f(n-1)+f(n-2)
 * @author zhanglin
 *
 * @date 2018年5月27日
 */
public class Rabbit {

	public static void main(String[] args) {
		Rabbit r = new Rabbit();
		for (int i = 1; i < 10; i++) {
			System.out.println(i + ":" + r.function(i));
		}
	}
	
	public int function(int month) {
		if (month <= 0) return 0;
		if (month == 1 || month == 2)
			return 1;
		return function(month - 1) + function(month -2);
	}
}
