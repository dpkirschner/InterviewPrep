package com.kirscd.dynamicProgramming;

public class LongestPalindromeSubString {
	public static String value = "forgeeksskeegfor";
	
	public static String expandCenter(int one, int two) {
		int left = one;
		int right = two;
		
		while(left >= 0 && right < value.length() && value.charAt(left) == value.charAt(right)) {
			left--;
			right++;
		}
		return value.substring(left+1, right);
	}
	
	public static String solve() {
		String longest = value.substring(0, 1);
		
		for(int i = 0; i < value.length()-1; i++) {
		
			String temp = expandCenter(i, i+1);
			if(longest.length() < temp.length()) {
				longest = temp;
			}
		}
		
		
		return longest;
	}
	
	public static void main(String args[]) {
		System.out.println(solve());
	}
}
