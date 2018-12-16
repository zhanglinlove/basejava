package com.sheji;

public class ConcreteHandler extends Handler{

	private String name;
	public ConcreteHandler(String name) {
		this.name = name;
	}
	
	public void handlerRequest(HandlerChain chain) {
		System.out.println("进入过滤器：" + name);
		int i = 1;
		if (i > 0) {
			System.out.println("放过请求");
			
		} else {
			System.out.println("处理请求");
		}
		chain.doFilter();
	}

}
