package com.basicmath;

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个正整数分解质因数。例如：输入90,打印出90=2*3*3*5。 
1.程序分析：对n进行分解质因数，应先找到一个最小的质数i，然后
按下述步骤完成： 
(1)如果这个质数恰等于n，则说明分解质因数的过程已经结束，打印
出即可。
(2)如果n > i，但n能被i整除，则应打印出i的值，并用n除以i的商,
作为新的正整数你,重复执行第一步。
(3)如果n不能被i整除，则用i+1作为i的值,重复执行第一步。
 * @author zhanglin
 *
 * @date 2018年5月27日
 */
public class Factor {

	public static void main(String[] args) {
		Factor f = new Factor();
		for (int i = 100; i < 120; i++) {
			List<Integer> list = f.isFactor(i);
			System.out.println(i + "分解为:" + list);
		}
	}
	
	public List<Integer> isFactor(int num) {
		List<Integer> list = new ArrayList<>();
		int count = num/2;
		for (int i = 2; i < count;) {
			if (num % i == 0) {
				list.add(i);
				num = num / i;
				continue;
			}
			i++;
		}
		return list;
	} 
}
