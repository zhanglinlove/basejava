package com.sheji.proxy;

public class UserImpl implements User{

	@Override
	public void save() {
		System.out.println("已经保存数据。");
	}

}
