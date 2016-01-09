package com.kirscd.dynamicProgramming;

import com.kirscd.utilities.Utils;

/*
 * There are N houses built in a line, each of which contains some value in it. 
 * A thief is going to steal the maximal value in these houses, 
 * but he cannot steal in two adjacent houses because the owner of a 
 * stolen house will tell his two neighbors on the left and right side. 
 * What is the maximal stolen value?
 */
public class StolenValues {
	public static int[] values;
	public static int recursive() {
		return recursive(0);
	}
	
	/**
	 * Choose the higher of two outcomes
	 * 	take this value and skip the next one
	 * 	ignore this value and take the next one
	 * 
	 * This suffers from the problem that we recalculate values multiple times. Imagine that there are 
	 * 9999 houses. Every time we make a decision we do a DFS on the solutions. This means that we calculate
	 * every possibility involving the last house many, many, many times, even though there is only one
	 * best solution.
	 * @param index
	 * @return
	 */
	public static int recursive(int index) {
		if(index >= values.length) {
			return 0;
		}
		
		return Math.max(values[index] + recursive(index + 2), recursive(index + 1));
	}

	
	/**
	 * Build a new array of highestValues where each index represents the highest possible 
	 * value up to that point. Each new spot can be calculated by taking the max of our previous decisions
	 * 	add this value and the one two steps behind 
	 * 	ignore this value and carry over the one directly behind it
	 * 
	 * The key point here is that we don't care about any future decisions, we only care about which choice
	 * gives us the max at our current spot. Either its the fact we skipped the previous house and can take this one,
	 * or we took the last house and can't take this one.
	 * @return
	 */
	public static int iterative() {
		int[] highestValue = new int[values.length];
		for(int i = 0; i < highestValue.length; i++) {
			int take = values[i];
			if(i >= 2) {
				take = take + highestValue[i-2];
			}
			int ignore = 0;
			if(i >= 1) {
				ignore = highestValue[i-1];
			}
			highestValue[i] = Math.max(take, ignore);
			
			for(int j : highestValue) {
				System.out.print(j + ":");
			}
			System.out.println();
		}
		
		return highestValue[highestValue.length - 1];
	}
	
	public static void main(String args[]) {
		values = Utils.buildIntArray(5, -100, 100);
		
		Utils.printIntArray(values);
		
		System.out.println("iterative: " + iterative());
		System.out.println("recursive: " + recursive());
	}
}
