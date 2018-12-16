package com.collection;

import java.lang.ref.SoftReference;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

public class WeakHashTable {

	public static void main(String[] args) {
		method2();
	}
	
	public static void method1() {
		WeakHashMap w = new WeakHashMap<>();
		w.put(new String("语文"), new String("优秀"));
		w.put(new String("数学"), new String("及格"));
		w.put(new String("英语"), new String("中等"));
		
		w.put("java", new String("特别优秀"));
		System.out.println(w);
		System.gc();
		System.runFinalization();
		System.out.println("第二次：" + w);
	}
	
	public static void method2() {
		Object referent = new Object();
		SoftReference<Object> soft = new SoftReference<Object>(referent);
		
		if (soft.get() != null) {
			System.out.println("obj is live...");
		}
		referent = null;
		System.gc();
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (soft.get() != null) {
			System.out.println("回收后还存在" );
		} else {
			System.out.println("回收后不存在。");
		}
	}
}
