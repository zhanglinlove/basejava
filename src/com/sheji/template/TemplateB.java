package com.sheji.template;

public class TemplateB extends AbstractTemplate{

	@Override
	protected void abstractMethod() {
		System.out.println("TemplateB---abstractMethod");
	}

	@Override
	protected void hookMethod() {
		System.out.println("TemplateB---------hook");
	}

}
