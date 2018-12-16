package com.sheji;

public class ChineseFactory implements IFamilyFactory{

	@Override
	public IFather createFather(String name) {
		
		return new ChineseFather(name);
	}

	@Override
	public IMother createMother(String name) {
		
		return new ChineseMother(name);
	}

}
