package com.base;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 前六位数（20150826）是年月日格式化：yyyyMMdd
                中间的8位数（00001000）是：00001000，固定4个0+1000
                在后两位（04）：随机生成一个两位数
                在后两位（00）：又是固定的两个0
                接下来的6位数是（617496）：时分秒的格式化HHmmss
                最后两位是（94）：又是随机生成
 * @author zhanglin
 *
 */
public class Test02 {

	public static void main(String[] args) {
		long a = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			System.out.println(a + getTwo() + getTwo());
		}
	}
	
	public static String getTwo() {
		Random r = new Random();
		String value = r.nextInt(100) + "";
		if (value.length() == 1) {
			value = "0" + value;
		}
		return value;
	}
}
