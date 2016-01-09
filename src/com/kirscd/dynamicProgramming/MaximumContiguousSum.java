package com.kirscd.dynamicProgramming;

import java.util.Random;

public class MaximumContiguousSum {
	
	public static int solve(int[] values) {
		return solve(values, 0, values.length-1);
	}
	
	public static int solve(int[] values, int lower, int upper) {
		if(lower == upper) {
			return values[upper];
		}
		if(lower > upper) {
			return 0;
		}
		
		int mid = (lower+upper)/2;
		
		int lmax = 0;
		int sum = 0;
		for(int i = mid; i >= lower; i--) {
			sum += values[i];
			if(sum > lmax) {
				lmax = sum;
			}
		}
		
		int rmax = 0;
		sum = 0;
		for(int j = mid+1; j <= upper; j++) {
			sum += values[j];
			if(sum > rmax) {
				rmax = sum;
			}
		}
		
		return MaximumContiguousSum.max(
				solve(values, lower, mid)
				, lmax + rmax
				, solve(values, mid+1, upper));

	}
	
	public static int linear(int[] values) {
		if(values.length == 0) {
			return 0;
		}
		
		int maxHere = 0;
		int currentMax = 0;
		
		for(int i = 0; i < values.length; i++) {
			maxHere = Math.max(maxHere + values[i], values[i]);
			currentMax = Math.max(currentMax, maxHere);
		}
		
		return currentMax;
	}
	
	public static int max(int a, int b, int c) {
		if(a >= b && a >= c) {
			return a;
		}
		
		if(b >= c && b >= a) {
			return b;
		}
		
		return c;
	}
	
	
	public static void main(String args[]) {
		int[] values = buildRandomArray(5, -100, 100);
		printArray(values);
		
		System.out.println("divide and conquer: " + solve(values));
		System.out.println("dynamic programming: " + linear(values));
	}
	
	public static int[] buildRandomArray(int size, int lowBound, int highBound) {
		int[] mine = new int[size];
		Random r = new Random();
		
		for(int i = 0; i < size; i++) {
			mine[i] = r.nextInt(highBound - lowBound) + lowBound;
		}

		return mine;
	}
	
	public static void printArray(int[] values) {
		for(int value : values) {
			System.out.print(value + " : ");
		}
		System.out.println();
	}
}
