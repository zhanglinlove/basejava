package com.base;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandlerFactory;

public class MyUrlClassLoader extends URLClassLoader {

	public MyUrlClassLoader(URL[] urls) {
		super(urls);
		// TODO Auto-generated constructor stub
	}

	public MyUrlClassLoader(URL[] urls, ClassLoader parent, URLStreamHandlerFactory factory) {
		super(urls, parent, factory);
		// TODO Auto-generated constructor stub
	}

	public MyUrlClassLoader(URL[] urls, ClassLoader parent) {
		super(urls, parent);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
		/*String rootDir = "F:\\log\\classloader";
		File f = new File(rootDir);
		URI uri = f.toURI();
		URL[] urls = {uri.toURL()};
		MyUrlClassLoader loader = new MyUrlClassLoader(urls);
		Class<?> clazz = loader.loadClass("com.base.DemoObject");
		System.out.println(clazz.newInstance().toString());
		loader.close();*/
		String rootDir = "F:\\log\\classloader";
		File f = new File(rootDir);
		URI uri = f.toURI();
		URL[] urls = {uri.toURL()};
		MyUrlClassLoader loader = new MyUrlClassLoader(urls);
		MyUrlClassLoader loader2 = new MyUrlClassLoader(urls);
		
		Class<?> obj = loader.loadClass("com.base.DemoObject");
		Class<?> obj2 = loader.loadClass("com.base.DemoObject");
		
		System.out.println("loadClass->obj:" + obj.hashCode());
		System.out.println("loadClass->obj2:" + obj2.hashCode());
		
		loader.close();
		loader2.close();
	}
}
