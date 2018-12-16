package com.sheji.decorate;
/**
 * 装饰者模式。
 * @author zhanglin
 *
 */
public class Test {

	public static void main(String[] args) {
		Component c = new ConcreteComponent();
		
		ConcreteDecorator con1 = new ConcreteDecorator(c);
		con1.operation();
		
		System.out.println("----------分割线-----------");
		ConcreteDecoratorB con2 = new ConcreteDecoratorB(con1);
		con2.operation();
	}
}
