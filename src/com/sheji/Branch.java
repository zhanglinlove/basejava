package com.sheji;

import java.util.ArrayList;
import java.util.List;

public class Branch extends Brantch{

	private String name;
	private List<Brantch> list = new ArrayList<>();
	
	public Branch(String name) {
		this.name = name;
	}
	
	@Override
	public void add(Brantch child) {
		// TODO Auto-generated method stub
		list.add(child);
	}

	@Override
	public void remove(Brantch child) {
		// TODO Auto-generated method stub
		list.remove(child);
	}

	@Override
	public List<Brantch> getChilds() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public void printStruct(String name) {
		System.out.println(name + ":" + this.name);
		if (this.list != null) {
			name += " ";
			for (Brantch c : list) {
				c.printStruct(name);
			}
		}
	}

}
