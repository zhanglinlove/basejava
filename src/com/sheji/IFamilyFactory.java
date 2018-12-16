package com.sheji;
/**
 * 抽象工厂接口。
 * @author zhanglin
 *
 */
public interface IFamilyFactory {

	public IFather createFather(String name);
	public IMother createMother(String name);
}
