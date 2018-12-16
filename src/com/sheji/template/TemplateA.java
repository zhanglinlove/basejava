package com.sheji.template;

public class TemplateA extends AbstractTemplate{

	@Override
	protected void abstractMethod() {
		System.out.println("TemplateA---abstractMethod");
	}

	@Override
	protected void hookMethod() {
		System.out.println("TemplateA---------hook");
	}

}
