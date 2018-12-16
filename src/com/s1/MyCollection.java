package com.s1;

import java.util.Arrays;

/**
 * 表的基本操作:初始化、获取表长、查找、获取节点、插入、删除
 * @author zhanglin
 *
 * @date 2018年6月30日
 */
public class MyCollection {

	Data[] obj = null;
	int length;
	private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
	
	public MyCollection(Data[] obj, int length) {
		super();
		this.obj = obj;
		this.length = length;
	}
	
	public MyCollection() {
		this.obj = new Data[20];
		this.length = 0;
	}
	
	public int size() {
		return length;
	}
	
	public Data search(int index) {
		if (index < 0 || index > length) {
			throw new IllegalArgumentException("索引错误");
		}
		return obj[index];
	}
	
	public boolean isExists (Data data) {
		if (data == null) return false;
		for (int i = 0 ; i < length; i++) {
			if (data.equals(obj[i])) return true;
		}
		return false;
	}
	
	public void insert(Data data) {
		if (length + 1 >= obj.length) {
			extendLength(length + 1);
		}
		obj[length++] = data;
	}
	
	public void insert(int index, Data data) {
		if (index < 0 || index >= length)
			throw new IllegalArgumentException("参数异常");
		if (length + 1 >= obj.length) {
			extendLength(length + 1);
		}
		int move = obj.length - index - 1;
		if (move > 0) {
			System.arraycopy(obj, index, obj, index + 1, move);
		}
		obj[index] = data;
		length++;
	}
	
	private void extendLength(int length) {
		int oldCapacity = obj.length;
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		if (newCapacity >= MAX_ARRAY_SIZE) {
			newCapacity = MAX_ARRAY_SIZE;
		}
		if (newCapacity < length) {
			newCapacity = length;
		}
		obj = Arrays.copyOf(obj, newCapacity);
	}
	
	public Data delete(int index) {
		if (index < 0 || index >= length) 
			throw new IllegalArgumentException("索引错误");
		Data old = obj[index];
		int move = length - index - 1;
		if (move > 0) {
			System.arraycopy(obj, index + 1, obj, index, move);
		}
		obj[--length] = null;
		return old;
	}
	
	public Data delete(Data data) {
		if (data == null)
			throw new IllegalArgumentException("非法参数异常");
		for (int i = 0; i < length; i++) {
			if (data.equals(obj[i])) {
				delete(i);
			}
		}
		return null;
	}
	
	public String print() {
		if (length == 0) return "[]";
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for (int i = 0; ; i++) {
			sb.append(obj[i].toString());
			if (i == length - 1)
				return sb.append("]").toString();
			sb.append(",");
		}
	}
}
