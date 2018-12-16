package com.jvm.part10;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassLoaderTest {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		DiskClassLoader loader = new DiskClassLoader("F:\\test\\com\\jvm\\part10");
		Class clazz = loader.findClass("com.jvm.part10.Test");
		if (clazz != null) {
			Object obj = clazz.newInstance();
			Method method = clazz.getDeclaredMethod("print", null);
			method.invoke(obj, null);
		}
		
	}
}
