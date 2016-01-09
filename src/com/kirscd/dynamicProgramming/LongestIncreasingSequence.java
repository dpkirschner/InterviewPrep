package com.kirscd.dynamicProgramming;

import com.kirscd.utilities.Utils;


public class LongestIncreasingSequence {
	public static int[] values;
	public static int solve() {
		int[] longest = new int[values.length];
		
		for(int i = 0; i < values.length; i++) {
			int max = 0;
			for(int j = 0; j < i; j++) {
				if(values[j] < values[i] && max < longest[j]) {
					max = longest[j];
				}
			}
			longest[i] = max + 1;
		}
		
		Utils.printIntArray(longest);
		
		int max = 0;
		for (int i : longest) {
			if(i > max) {
				max = i;
			}
		}
		
		return max;
	}
	
	public static void main(String args[]) {
		values = Utils.buildIntArray(5, 0, 20);
		Utils.printIntArray(values);
		System.out.println(solve());
	}
}
