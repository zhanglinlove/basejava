package com.jvm.part07;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test2 {

	static class MyLoader extends ClassLoader {

		private String classPath;

        public MyLoader(String classPath) {
            this.classPath = classPath;
        }
        
		@Override
		protected Class<?> findClass(String name) throws ClassNotFoundException {
			try {
				byte[] b = loadByte(name);
				return defineClass(name, b, 0, b.length);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return super.findClass(name);
		}
		
		private byte[] loadByte(String name) throws IOException {
			name = name.replaceAll("\\.", "/");
			FileInputStream fis = new FileInputStream(classPath + "/" + name + ".class");
			int len = fis.available();
			byte[] b = new byte[len];
			fis.read(b);
			fis.close();
			return b;
		}
	}
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		MyLoader loader = new MyLoader("F:/log");
		Class clazz = loader.loadClass("com.jvm.part07.Test");
		Object obj = clazz.newInstance();
		Method method = clazz.getDeclaredMethod("hello", null);
		method.invoke(obj, null);
	}
}
