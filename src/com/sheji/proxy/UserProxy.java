package com.sheji.proxy;

public class UserProxy implements User{

	private User target;
	
	public UserProxy(User user) {
		this.target = user;
	}
	
	@Override
	public void save() {
		System.out.println("开始工作");
		target.save();
		System.out.println("结束工作");
	}

}
