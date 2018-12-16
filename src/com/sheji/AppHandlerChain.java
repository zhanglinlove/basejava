package com.sheji;

import java.util.ArrayList;
import java.util.List;

public class AppHandlerChain implements HandlerChain{

	private int i = 0;
	private int pos = 0;
	private List<Handler> list = new ArrayList<Handler>();
	private HandlerChain chain = null;
	public AppHandlerChain() {
		this.chain = this;
	}
	public void doFilter() {
		i = list.size();
		if (pos < i) {
			Handler h = list.get(pos++);
			
			h.handlerRequest(chain);
		} else {
			System.out.println("filter处理完成，调用servlet");
		}
		
	}
	
	public void addFilter(Handler handler) {
		list.add(handler);
	}
}
