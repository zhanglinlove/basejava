package com.sheji.decorate;

public class ConcreteDecoratorB extends ConcreteDecorator{

	public ConcreteDecoratorB(Component component) {
		super(component);
	}

	public void concreteDecoratorFirst() {
		System.out.println("ConcreteDecoratorB装饰前的操作。。。");
	}
	
	public void concreteDecoratorLast() {
		System.out.println("ConcreteDecoratorB装饰后的操作。。。");
	}

	public void operation() {
		concreteDecoratorFirst();
		super.operation();
		concreteDecoratorLast();
	}
}
