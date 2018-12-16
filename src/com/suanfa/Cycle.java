package com.suanfa;

import java.util.LinkedList;
import java.util.List;
/**
 * 50个人围成一圈，每数到3或3的倍数，就退出该元素。
 * 返回最后剩下的元素。
 * @author zhanglin
 *
 */
public class Cycle {

	public static void main(String[] args) {
		int num = getCycle(50, 3);
		System.out.println("最后剩下的元素是：" + num);
	}
	
	public static int getCycle(int total, int num) {
		List list = new LinkedList();
		for (int i = 1; i <= 50; i++) {
			list.add(i);
		}
		int index = -1;
		while (list.size() > 1) {
			index = (index + num) % list.size();
			list.remove(index--);
		}
		return ((Integer) list.get(0)).intValue();
	}
} 
