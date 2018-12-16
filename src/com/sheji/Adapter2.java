package com.sheji;
/**
 * 对象适配器。
 * @author zhanglin
 *
 */
public class Adapter2 implements Target{

	private Adaptee adaptee;
	public Adapter2(Adaptee adaptee) {
		this.adaptee = adaptee;
	}

	public void sampleOperation1() {
		adaptee.sampleOperation1();
	}

	@Override
	public void sampleOperation2() {
		// TODO Auto-generated method stub
		
	}

}
