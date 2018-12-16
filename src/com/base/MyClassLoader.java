package com.base;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.jvm.part07.GetSuperClassLoader;

public class MyClassLoader extends ClassLoader{

	private String rootDir;
	
	public MyClassLoader(String rootDir) {
		super();
		this.rootDir = rootDir;
	}

	public String getRootDir() {
		return rootDir;
	}

	public void setRootDir(String rootDir) {
		this.rootDir = rootDir;
	}

	private byte[] getClassData(String name) {
		String className = classNameToPath(name);
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(new File(className));
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			byte[] b = new byte[4096];
			while (fis.read(b) != -1) {
				bos.write(b, 0, b.length);
			}
			return bos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null)
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return null;
	}
	
	private String classNameToPath(String dir) {
		return rootDir + File.separator + dir.replaceAll(".", File.separator)
			+ ".class";
	}
	
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		byte[] data = getClassData(name);
		if (data == null) {
			throw new ClassNotFoundException(name + " not found");
		} else {
			defineClass(name, data, 0, data.length);
		}
		return super.findClass(name);
	}

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		MyClassLoader loader = new MyClassLoader("F:\\log\\classloader");
		Class<?> clazz = loader.loadClass("com.base.DemoObject");
		System.out.println(clazz.newInstance().toString());
		System.out.println(loader.getParent());
	}
}
