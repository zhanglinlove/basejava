package com.audition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

	public static void main(String[] args) {
		int minValue = Stream.of(2, 3, 4, -2).reduce(0, Integer::sum);
		System.out.println(minValue);

	}
}
