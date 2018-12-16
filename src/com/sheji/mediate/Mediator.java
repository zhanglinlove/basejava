package com.sheji.mediate;

/**
 * 调停者接口
 * @author zhanglin
 *
 */
public interface Mediator {

	/**
	 * 同事对象在自身发生变化时通知调停者，
	 * 由调停者负责与其他同事交互。
	 * @param c
	 */
	public void change(Colleague c);
}
