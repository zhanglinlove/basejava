package com.gaoji;
/**
 * 观察者模式。
 * @author zhanglin
 *
 */
public class ObServerPattern {

	public static void main(String[] args) {
		Product p = new Product("《Java核心技术》", 103.00);
		ObServer server1 = new WebObServer();
		ObServer server2 = new MailObjServer();
		p.addObServer(server1);
		p.addObServer(server2);
		System.out.println("第一次价格变动");
		p.setPrice(89.50);
		System.out.println("第二次价格变动");
		p.setPrice(92.45);
	}
}
