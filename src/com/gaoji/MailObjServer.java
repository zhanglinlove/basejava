package com.gaoji;

public class MailObjServer implements ObServer{

	public void update(Product p) {
		System.out.println("为会员发送价格变化信息：" + p.getName() + ":" + p.getPrice());
	}

	public void unreg(Product p) {
		p.getSet().remove(this);
	}

}
