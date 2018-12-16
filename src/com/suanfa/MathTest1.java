package com.suanfa;
/**
 * 如果它存在两个因数，乘积等于M，
 * 这两个因数一定一个小于根号M，一个大于根号M，
 * 因为一定存在两个相等的数乘积等于它（当然可能不是整数），
 * 这两个数就是根号M，因为M = 根号M * 根号M。如果两个数都
 * 在根号M以下，乘起来小于M，如果两个数都在根号M以上，乘起
 * 来一定大于M，所以两个数分布于根号M两边，那么我们只要找到
 * 其中一半有没有这样一个整数就可以了。如果有，自然对应的另
 * 一半也有一个和它对应的数，使它们的乘积为M。
 * @author zhanglin
 *
 */
public class MathTest1 {

	public static void main(String[] args) {
		printSu();
	}
	
	public static boolean getMath(int num) {
		if (num < 2) {
			return false;
		}
		int j = (int) Math.sqrt(num);
		for (int i = 2; i <= j; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void printSu() {
		for (int i = 1; i <= 100; i++) {
			boolean bl = getMath(i);
			if (bl) {
				System.out.println(i + "是素数.");
			}
		}
	}
}
