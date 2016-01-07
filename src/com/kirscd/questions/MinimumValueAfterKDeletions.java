package com.kirscd.questions;

public class MinimumValueAfterKDeletions {
	public static String value = "246";
	
	public static String solve(int toDelete) {
		String mini = value;
		for(int i = toDelete; i > 0; i++) {
			int last = Integer.valueOf(String.valueOf(mini.charAt(0)));
			int index = 0;
			for(int j = 1; j < mini.length(); j++) {
				if(mini.charAt(j) >= last) {
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
