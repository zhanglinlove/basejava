package com.gaoji;

public class WebObServer implements ObServer{

	public void update(Product p) {
		System.out.println("更新页面价格：" + p.getName() + ":" + p.getPrice() );
	}

	public void unreg(Product p) {
		p.getSet().remove(this);
	}

}
