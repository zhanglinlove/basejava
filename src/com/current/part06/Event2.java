package com.current.part06;

import java.util.Date;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Event2 implements Delayed{

	private Date startDate;
	
	public Event2(Date startDate) {
		this.startDate = startDate;
	}
	
	@Override
	public int compareTo(Delayed o) {
		// TODO Auto-generated method stub
		long result = this.getDelay(TimeUnit.NANOSECONDS) - 
				o.getDelay(TimeUnit.NANOSECONDS);
		if (result > 0) {
			return 1;
		} else if (result < 0){
			return -1;
		} else {
			return 0;
		}
		
	}

	@Override
	public long getDelay(TimeUnit unit) {
		// TODO Auto-generated method stub
		Date now = new Date();
		long diff = startDate.getTime() - now.getTime();
		return unit.convert(diff, TimeUnit.MILLISECONDS);
	}

}
