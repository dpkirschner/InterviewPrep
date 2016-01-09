package com.kirscd.dynamicProgramming;

import java.util.HashMap;

/**
 *Given a number, please translate it to a string, following the rules: 
 *	1 is translated to 'a', 2 to 'b', …, 12 to 'l', …, 26 to 'z'. 
 *For example, the number 12258 can be translated to "abbeh", "aveh", "abyh", "lbeh" and "lyh", 
 *so there are 5 different ways to translate 12258. 
 *How to write a function/method to count the different ways to translate a number?
 */
public class TranslateNumbersToStrings {
	public static String value = "12258";
	
	public static HashMap<Integer, String> values = generateMapping();
	
	public static int solve() {
		int[] mine = new int[value.length()];
		
		for(int i = value.length() - 1; i >=0; i--) {
			int thisValue = 0;
			int doubleValue = 0;
			int lastLastValue = i < value.length() - 2 ? mine[i + 2] : 1;
			//if this character is 0, we know that there can't be a valid single character 
			//and we can't use this as the first part of a double character
			if(value.charAt(i) != '0') {
				thisValue = i < value.length() - 1 ? mine[i + 1] : 1;
				doubleValue = i < value.length() - 1 && values.containsKey(Integer.valueOf(String.valueOf(value.charAt(i)) + String.valueOf(value.charAt(i+1)))) ? 1 : 0;
			}	
			
			mine[i] = thisValue + (doubleValue * lastLastValue);
		}
		
		for(int i : mine) {
			System.out.print(i + ":");
		}
		System.out.println();
		
		return mine[0];
	}
	
	public static void main(String args[]) {
		System.out.println(solve());
	}

	/**
	 * 
	 */
	private static HashMap<Integer, String> generateMapping() {
		HashMap<Integer, String> mapping = new HashMap<Integer, String>();
		mapping.put(1, "a");
		mapping.put(2, "b");
		mapping.put(3, "c");
		mapping.put(4, "d");
		mapping.put(5, "e");
		mapping.put(6, "f");
		mapping.put(7, "g");
		mapping.put(8, "h");
		mapping.put(9, "i");
		mapping.put(10, "j");
		mapping.put(11, "k");
		mapping.put(12, "l");
		mapping.put(13, "m");
		mapping.put(14, "n");
		mapping.put(15, "o");
		mapping.put(16, "p");
		mapping.put(17, "q");
		mapping.put(18, "r");
		mapping.put(19, "s");
		mapping.put(20, "t");
		mapping.put(21, "u");
		mapping.put(22, "v");
		mapping.put(23, "w");
		mapping.put(24, "x");
		mapping.put(25, "y");
		mapping.put(26, "z");
		return mapping;
	}
	
}
