package com.sheji;

public abstract class Handler {

	//设置后继对象
	protected Handler handler;
	
	public void setHandler(Handler handler) {
		this.handler = handler;
	}
	
	public Handler getHandler() {
		return handler;
	}
	
	public abstract void handlerRequest(HandlerChain chain);

}
