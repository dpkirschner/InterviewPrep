package com.kirscd.algorithms;

public class FastExponation {
	public static long solve(int base, int exp) {
		if(exp == 0) {
			return 1;
		}
		long x = solve(base, exp/2);
		if(exp % 2 == 0) {
			return x*x;
		}
		return base*x*x;
	}
	
	public static void main(String args[]) {
		System.out.println(FastExponation.solve(2, 32));
	}
}
