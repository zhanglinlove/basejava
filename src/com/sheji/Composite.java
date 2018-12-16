package com.sheji;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component{

	private String name;
	private List<Component> list = new ArrayList<>();
	
	public Composite(String name) {
		this.name = name;
	}
	
	public void add(Component component) {
		list.add(component);
	}
	
	public void remove(Component component) {
		list.remove(component);
	}
	
	public List<Component> getChilds() {
		return list;
	}
	
	@Override
	public void printStruct(String msg) {
		System.out.println(msg + ":" + this.name);
		if (this.list != null) {
			msg += " ";
			for (Component c : list) {
				c.printStruct(msg);
			}
		}
	}

}
