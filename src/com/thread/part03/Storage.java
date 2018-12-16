package com.thread.part03;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * 仓库
 * @author zhanglin
 *
 */
public class Storage {

	private List<Object> foods;
	
	public final static int MAX_SIZE = 5;
	
	public Storage() {
		foods = new ArrayList<Object>();
	}
	
	public void add() {
		foods.add(new Random().nextInt(100));
	}
	
	public int size() {
		return foods.size();
	}
	
	public void remove() {
		foods.remove(0);
	}
}
