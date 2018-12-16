package com.thread.part06;

public class MyObject {

	private static MyObject object = null;
	private MyObject() {}
	
	public static MyObject getInstance() {
		if (object == null) {
			synchronized (MyObject.class) {
				if (object == null) {
					object = new MyObject();
				}
			}
		}
		
		return object;
	}
}
