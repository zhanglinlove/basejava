package com.sheji.template;

public abstract class AbstractTemplate {

	/**
	 * 模板方法
	 */
	public final void templateMethod() {
		abstractMethod();
		hookMethod();
		concreateMethod();
	}
	
	/**
	 * 基本方法（接口）
	 */
	protected abstract void abstractMethod();
	
	/**
	 * 基本方法（已经实现）
	 */
	protected void hookMethod() {}
	
	/**
	 * 基本方法（已经实现）
	 */
	private final void concreateMethod() {
		System.out.println("这个方法已经实现。");
	}
}
