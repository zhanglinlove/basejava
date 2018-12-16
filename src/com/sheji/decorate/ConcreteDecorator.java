package com.sheji.decorate;

public class ConcreteDecorator extends Decorator{

	public ConcreteDecorator(Component component) {
		super(component);
	}

	public void concreteDecoratorFirst() {
		System.out.println("ConcreteDecorator装饰前的操作。。。");
	}
	
	public void concreteDecoratorLast() {
		System.out.println("ConcreteDecorator装饰后的操作。。。");
	}

	public void operation() {
		concreteDecoratorFirst();
		super.operation();
		concreteDecoratorLast();
	}
	
}
