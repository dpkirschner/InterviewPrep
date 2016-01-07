package com.kirscd.algorithms;

import java.util.HashMap;

public class Fibonacci {
	public static int exponential(int value) {
		if(value == 0) {
			return 0;
		}
		if(value == 1) {
			return 1;
		}
		
		return exponential(value-1) + exponential(value-2);
	}
	
	public static int linear(int value) {		
		HashMap<Integer, Integer> mine = new HashMap<Integer, Integer>();
		
		mine.put(0, 0);
		mine.put(1, 1);
		
		for(int i = 2; i <= value; i++) {
			mine.put(i, mine.get(i-2) + mine.get(i-1));
		}
		return mine.get(value);
	}
	
	public static void main(String args[]) {
		int value = 25;
//		long start = System.nanoTime();
//		int result = Fibonacci.exponential(value);
//		long totalTime = start - System.nanoTime();
//		System.out.println(String.format("Fib of %d (exponential) was %d and took %d seconds to solve", value, result, totalTime));
//		
		
		long start = System.nanoTime();
		long result = Fibonacci.linear(value);
		long totalTime = start - System.nanoTime();
		System.out.println(String.format("Fib of %d (linear) was %d and took %d seconds to solve", value, result, totalTime/1000000));
	}
}
