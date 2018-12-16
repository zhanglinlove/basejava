package com.sheji;

import java.util.List;

public abstract class Brantch {

	public abstract void printStruct(String name);
	
	public void add(Brantch child) {
		throw new UnsupportedOperationException("对象不支持此功能。");
	}
	
	public void remove(Brantch child) {
		throw new UnsupportedOperationException("对象不支持此功能。");
	}
	
	public List<Brantch> getChilds() {
		throw new UnsupportedOperationException("对象不支持此功能。");
	}
}
