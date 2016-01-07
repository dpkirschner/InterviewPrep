package com.kirscd.questions;

/**
 * Given an integer, return the minimum possible value after removing K digits.
 * The smallest version of 246, removing 1 digit, is 24. The smallest version of 246712, 
 * removing 2 digits is 2412. The only operation allowed is character deletion, not rotation or swaps etc.
 */
public class MinimumValueAfterKDeletions {
	public static String value = "232178";
	
	public static String solve(int toDelete) {
		String mini = value;
		for(int i = toDelete; i > 0; i--) {
			int last = Integer.valueOf(String.valueOf(mini.charAt(0)));
			int index = 0;
			for(int j = 1; j < mini.length(); j++) {
				if(Integer.valueOf(String.valueOf(mini.charAt(j))) >= last) {
					last = Integer.valueOf(String.valueOf(mini.charAt(j)));
					index = j;
					if(j == mini.length()-1) {
						mini = removeCharAt(mini, index);
					}
				} else {
					mini = removeCharAt(mini, index);
					break;
				}
			}
		}
		
		return mini;
	}

	/**
	 * @param mini
	 * @param index
	 * @return
	 */
	private static String removeCharAt(String mini, int index) {
		String mine = mini.substring(0, index);
		if(index < mini.length() - 1) {
			mine = mine + mini.substring(index+1, mini.length());
		}
		return mine;
	}
	
	public static void main(String args[]) {
		System.out.println(solve(1));
	}
}
