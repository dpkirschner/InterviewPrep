package com.kirscd.algorithms;

public class LongestIncreasingSubsequence {

	public static int solve(int[] values) {
		int[] mine = new int[values.length];
		
		//for every value we have
		for(int i = 0; i < values.length; i++) {
			int maxSeq = 1;
			//for every value we have already looked at
			for(int j = 0; j < i; j++) {
				//if the previous value is lower than ours and the seq that value ends
				//if longer than ours (or the default seq of length 1)
				if(values[i] > values[j] && mine[j] >= maxSeq) {
					//add our value to that sequence and update our new sequence length
					maxSeq = mine[j] + 1;
				}
			}
			mine[i] = maxSeq;
		}
		
		int max = 0;
		for(int i = 0; i < values.length; i++) {
			if(mine[i] > max) {
				max = mine[i];
			}
		}
		return max;
	}
	
	public static void main(String args[]) {
		int[] mine = {9, 5, 2, 8, 7, 3, 1, 6, 4};
		//int[] mine = {1, 2};
		System.out.println(LongestIncreasingSubsequence.solve(mine));
	}
}
