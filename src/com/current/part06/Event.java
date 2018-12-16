package com.current.part06;

public class Event implements Comparable<Event>{

	private int thread;
	private int priority;
	
	public Event(int thread, int priority) {
		this.thread = thread;
		this.priority = priority;
	}
	
	public int getThread() {
		return thread;
	}

	public int getPriority() {
		return priority;
	}

	@Override
	public int compareTo(Event o) {
		// TODO Auto-generated method stub
		if (this.priority > o.getPriority()) {
			return -1;
		} else if (this.priority < o.getPriority()) {
			return 1;
		}
		return 0;
	}

}
