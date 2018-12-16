package com.jvm.part10;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DiskClassLoader extends ClassLoader{

	private String path;
	
	public DiskClassLoader(String path) {
		this.path = path;
	}
	
	@Override
	public Class<?> findClass(String name) throws ClassNotFoundException {
		String fileName = getFileName(name);
		File f = new File(path, fileName);
		try {
			FileInputStream fis = new FileInputStream(f);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			int len = 0;
			while ((len = fis.read()) != -1) {
				bos.write(len);
			}
			byte[] b = bos.toByteArray();
			fis.close();
			bos.close();
			return defineClass(name,  b, 0, b.length);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return super.findClass(name);
	}

	private String getFileName(String name) {
		int index = name.lastIndexOf(".");
		if (index == -1) {
			return name + ".class";
		} else {
			return name.substring(index + 1) + ".class";
		}
	}
}
