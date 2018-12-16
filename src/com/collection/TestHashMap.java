package com.collection;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Set;

public class TestHashMap<K,V> extends AbstractMap<K, V>
		implements Map<K,V>, Cloneable, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5322626503278467338L;

	static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
	
	static final int MAXIMUM_CAPACITY = 1 << 30;
	
	static final float DEFAULT_LOAD_FACTOR = 0.75f;
	
	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

}
