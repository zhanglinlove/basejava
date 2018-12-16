package com.sheji.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {

	private Object target;
	
	public ProxyFactory(Object target) {
		this.target = target;
	}
	
	public Object getProxyInstance() {
		return Proxy.newProxyInstance(target.getClass().getClassLoader()
					, target.getClass().getInterfaces(), new InvocationHandler() {
						
						@Override
						public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
							// TODO Auto-generated method stub
							System.out.println("开始工作。");
							Object obj = method.invoke(target, args);
							System.out.println("结束工作。");
							return obj;
						}
					});
	}
}
