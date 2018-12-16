package com.sheji;

import java.util.ArrayList;
import java.util.List;
/**
 * 被观察者。
 * @author zhanglin
 *
 */
public class SubjectCar {

	private List<CarListener> list = new ArrayList<>();
	private Object lock = new Object();
	
	public void addListener(CarListener listener) {
		synchronized (lock) {
			list.add(listener);
		}
	}
	
	public void deleteListener(CarListener listener) {
		synchronized (lock) {
			int i = list.indexOf(listener);
			if (i >= 0) {
				list.remove(listener);
			}
		}
	}
	
	public void notifyObserve() {
		String msg = "运钞车开始运输了。";
		for (int i = 0; i < list.size(); i++) {
			list.get(i).condition(msg);
		}
	}
	
	public void startMove() {
		notifyObserve();
	}
}
