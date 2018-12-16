package com.collection;

import java.lang.ref.WeakReference;

public class WeakReferenceTest {

	public static void main(String[] args) {
		Car car = new Car(12.2, "red");
		WeakReference<Car> weak = new WeakReference<Car>(car);
		int i = 0;
		while (true) {
			if (weak.get() != null) {
				i++;
				System.out.println("object is alive for " + i + " loops-"
							+ weak);
			} else {
				System.out.println("object has been collected.");
				break;
			}
		}
	}
}
