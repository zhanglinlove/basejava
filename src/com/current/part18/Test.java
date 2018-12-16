package com.current.part18;

import java.util.Arrays;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		String[] atp = {"Rafael Nadal", "Novak Djokovic",
			       "Stanislas Wawrinka",
			       "David Ferrer","Roger Federer",
			       "Andy Murray","Tomas Berdych",
			       "Juan Martin Del Potro"};
		List<String> players =  Arrays.asList(atp);
		for (String player : players) {
		     System.out.print(player + "; ");
		}
		players.forEach((p) -> System.out.println(p + ";"));
		
	}
	
}
