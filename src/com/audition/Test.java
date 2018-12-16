package com.audition;

public class Test {

	public static void main(String[] args) {
		String s1 = "38948598490";
		String s2 = "398758476";
		String s = merge(s1, s2);
		System.out.println(s);
	}

	
	public static String merge(String s1, String s2) {
		char[] a1 = s1.toCharArray();
		char[] a2 = s2.toCharArray();
		StringBuilder sb = new StringBuilder();
		int len1 = a1.length;
		int len2 = a2.length;
		
		int temp = 0;
		int i;
		for (i = 0; i < len1 && i < len2; i++) {
			int left = Integer.valueOf(a1[len1 - i - 1] + "");
			int right = 0;
			right = Integer.valueOf(a2[len2 - i - 1] + "");
			left = left + right + temp;
			temp = left / 10;
		
			int h = left % 10;
			sb.append(h + "");
		}
		if (len1 != len2) {
			if (i + 1 == len1) {
				for (i = len1; i < len2; i++) {
					int t = Integer.valueOf(a2[len2 - i - 1] + "");
					t = t + temp;
					temp = t / 10;
					
					int h = t % 10;
					sb.append(h + "");
				}
			} else {
				for (i = len2; i < len1; i++) {
					int t = Integer.valueOf(a1[len1 - i - 1] + "");
					t = t + temp;
					temp = t / 10;
					
					int h = t % 10;
					sb.append(h + "");
				}
			}
		}
		
		String s = sb.toString();
		sb = new StringBuilder();
		int l = s.length();
		for (int j = l - 1; j >= 0; j--) {
			sb.append(s.charAt(j) + "");
		}
		return sb.toString();
	}
}
