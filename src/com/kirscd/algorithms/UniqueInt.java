package com.kirscd.algorithms;


/**
 * https://www.interviewcake.com/question/java/find-unique-int-among-duplicates
 *
 */
public class UniqueInt {
	
	public static int[] values = {1, 1, 2, 2, 3, 4, 4, 5, 5};
	
	public static int solve() {
		int xyz = values[0];
		for(int i = 1; i < values.length; i++) {
			//XOR
			xyz = xyz ^ values[i];
		}
		return xyz;
	}

	public static void main(String[] args) {
		System.out.println(solve());
	}

}
