package com.basicmath;

/**
 * 利用条件运算符的嵌套来完成此题：学习成绩=90分的同学用A表示，
 * 60-89分之间的用B表示，60分以下的用C表示
 * @author zhanglin
 *
 * @date 2018年5月27日
 */
public class Score {

	public static void main(String[] args) {
		int a = 90;
		String m = a > 90 ? "A" : (a > 60 ? "B" : "c");
		System.out.println(m);
	}
}
