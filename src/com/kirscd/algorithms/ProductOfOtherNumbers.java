package com.kirscd.algorithms;

import com.kirscd.utilities.Utils;

/**
 * https://www.interviewcake.com/question/java/product-of-other-numbers
 *
 */
public class ProductOfOtherNumbers {
	public static int[] values = {1, 2, 6, 5, 9};
	
	public static int[] solve() {
		//2659	1659	1259	1269	1265
		
		
		int[] results = new int[values.length];
		
		int leftSide = 1;

		for(int i = 0; i < results.length; i++) {
			results[i] = leftSide;
			leftSide = leftSide * values[i];
		}
		
		int rightSide = 1;
		for(int i = results.length - 1; i >=0; i--) {
			results[i] = rightSide * results[i];
			rightSide = rightSide * values[i];
		}
		
		return results;
	}
	
	public static void main(String args[]) {
		Utils.printIntArray(solve());
	}

}
