package com.sheji;

public abstract class Test2 {

	public static void main(String[] args) {
		AppHandlerChain chain = new AppHandlerChain();
		ConcreteHandler c1 = new ConcreteHandler("filter1");
		ConcreteHandler c2 = new ConcreteHandler("filter2");
		ConcreteHandler c3 = new ConcreteHandler("filter3");
		chain.addFilter(c1);
		chain.addFilter(c2);
		chain.addFilter(c3);
		chain.doFilter();
	}

}
