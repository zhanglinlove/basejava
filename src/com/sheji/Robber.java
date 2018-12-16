package com.sheji;
/**
 * 观察者强盗.
 * @author zhanglin
 *
 */
public class Robber implements CarListener{

	@Override
	public void condition(String msg) {
		System.out.println("强盗：" + msg);
	}

}
