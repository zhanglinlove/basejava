package com.sheji;
/**
 * 观察者警察。
 * @author zhanglin
 *
 */
public class Police implements CarListener{

	@Override
	public void condition(String msg) {
		System.out.println("警察：" + msg);
	}

}
