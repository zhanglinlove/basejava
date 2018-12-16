package com.interview;

import java.io.UnsupportedEncodingException;

/**
 * 截取字符串长度。
 * 思路：先截取指定字符长度的字符串和字节数比较，大于就减一个字符再比较。
 * @author zhanglin
 *
 */
public class CharactorTest {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String str = "this a 好东西 good bye!";
		int[] ar = new int[] {1,2,4,6,8};
		System.out.println("截取前字段：" + str);
		String result = splitStrings(str, 11);
		System.out.println("截取后字段：" + result);
	}
	
	/**
	 * 截取字节。
	 * @param str
	 * @param len
	 * @return
	 */
	public static String splitStrings(String str, int len) {
		if (len <= 0)
			return "";
		if (len >= str.getBytes().length) {
			return str;
		}
		int num = len;
		String s = str.substring(0, num);
		byte[] b = s.getBytes();
		
		if (b.length == num) {
			return s;
		} 
		while (b.length > len) {
			s = str.substring(0, --num);
			b = s.getBytes();
		}
		return new String(b);
	}
}
