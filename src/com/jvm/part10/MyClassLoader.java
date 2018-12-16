package com.jvm.part10;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;

public class MyClassLoader extends URLClassLoader{

	public MyClassLoader(URL[] urls) {
		super(urls);
	}

	public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		String path = "F:\\test\\";
		File f = new File(path);
		URI uri = f.toURI();
		URL[] url = {uri.toURL()};
		MyClassLoader loader = new MyClassLoader(url);
		Class clazz = loader.findClass("com.jvm.part10.Test");
		System.out.println(clazz.newInstance().toString());
		if (clazz != null) {
			Object obj = clazz.newInstance();
			Method method = clazz.getDeclaredMethod("print", null);
			method.invoke(obj, null);
		}
	}
}
