package com.sheji;

public class AmericanFactory implements IFamilyFactory{

	@Override
	public IFather createFather(String name) {
		// TODO Auto-generated method stub
		return new AmericanFather(name);
	}

	@Override
	public IMother createMother(String name) {
		// TODO Auto-generated method stub
		return new AmericanMother(name);
	}

}
