package com.kirscd.questions;

import java.util.HashMap;

/**
 * Given a string, please get the length of the longest 
 * substring which does not have duplicated characters. 
 * Supposing all characters in the string are in the range from ‘a’ to ‘z’.
 */
public class LongestSubStringNoDuplicates {
	public static String value;// = "abcacfrar";
	
	public static int solve() {
		int currentLength = 0;
		int maxLength = 0;
		
		HashMap<Character, Integer> mine = new HashMap<Character, Integer>();
		for(int i = 0; i < value.length(); i++) {
			Integer previousIndex = mine.get(value.charAt(i));
			if(previousIndex == null || i - previousIndex > currentLength) {
				currentLength++;
			} else {
				if(currentLength > maxLength) {
					maxLength = currentLength;
				}
				
				currentLength = i - previousIndex;
			}
			mine.put(value.charAt(i), i);
		}
		
		if(currentLength > maxLength) {
			maxLength = currentLength;
		}
		return maxLength;
	}

	public static void main(String args[]) {
		//value = Utils.buildRandomString(10);
		value = "abcacfrar";
		System.out.println(value);
		System.out.println(solve());
		
		value = "acfrarabc";
		System.out.println(value);
		System.out.println(solve());
		
		value = "arabcacfr";
		System.out.println(value);
		System.out.println(solve());
		
		value = "aaaa";
		System.out.println(value);
		System.out.println(solve());
		
		value = "abcdefg";
		System.out.println(value);
		System.out.println(solve());
		
		value = "aaabbbccc";
		System.out.println(value);
		System.out.println(solve());
		
		value = "abcdcba";
		System.out.println(value);
		System.out.println(solve());
		
		value = "abcdaef";
		System.out.println(value);
		System.out.println(solve());
		
		value = "a";
		System.out.println(value);
		System.out.println(solve());
		
		value = "";
		System.out.println(value);
		System.out.println(solve());
	}
}
