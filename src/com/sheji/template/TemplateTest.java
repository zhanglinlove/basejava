package com.sheji.template;
/**
 * 模板方法.
 * @author zhanglin
 *
 */
public class TemplateTest {

	public static void main(String[] args) {
		AbstractTemplate t1 = new TemplateA();
		t1.templateMethod();
		
		AbstractTemplate t2 = new TemplateB();
		t2.templateMethod();
	}
}
