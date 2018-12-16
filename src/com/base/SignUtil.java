package com.base;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SignUtil {

	public static void main(String[] args) {
		String info = "good";
		String method = "MD5";
		System.out.println(encode(info, method));
		System.out.println(other(info, method));
	}
	
	public static String encode(String info, String method) {
		try {
			MessageDigest digest = MessageDigest.getInstance(method);
			digest.update(info.getBytes());
			byte[] b = digest.digest();
			return new BigInteger(1, b).toString(16);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static String other(String info, String method) {
		MessageDigest digest;
		try {
			char[] h = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
						, 'a', 'b', 'c', 'd', 'e', 'f'};
			digest = MessageDigest.getInstance(method);
			digest.update(info.getBytes());
			byte[] b = digest.digest();
			StringBuffer sb = new StringBuffer(b.length * 2);
			for (int i = 0; i < b.length; i++) {
				char high = (char) (h[(b[i] >>> 4) & 0xf]);
				char low = (char) (h[b[i] & 0xf]);
				sb.append(high);
				sb.append(low);
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
