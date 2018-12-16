package com.sheji;

public class Test5 {

	public static void main(String[] args) {
		SubjectCar car = new SubjectCar();
		
		CarListener c1 = new Police();
		CarListener c2 = new Robber();
		car.addListener(c1);
		car.addListener(c2);
		
		car.startMove();
		
	}
}
