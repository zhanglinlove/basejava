package com.sheji.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class ProxyNewFactory implements MethodInterceptor{

	private Object target;
	
	public ProxyNewFactory(Object target) {
		this.target = target;
	}
	
	public Object getInstance() {
		Enhancer en = new Enhancer();
		en.setSuperclass(target.getClass());
		en.setCallback(this);
		return en.create();
	}
	
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("开始工作。");
		Object returnValue = method.invoke(target, args);
		System.out.println("结束工作。");
		return returnValue;
	}

}
