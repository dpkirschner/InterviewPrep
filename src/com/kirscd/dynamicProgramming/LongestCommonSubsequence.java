package com.kirscd.dynamicProgramming;

import com.kirscd.utilities.Utils;

public class LongestCommonSubsequence {
	public static String recursive(String one, String two) {
		return recursiveHelper(one, two, "");
	}
	
	public static String recursiveHelper(String one, String two, String suffix) {
		if(one.length() == 0 || two.length() == 0) {
			return suffix;
		}
		
		while(one.length() > 0 && two.length() > 0 && one.charAt(one.length()-1) == two.charAt(two.length()-1)) {
			suffix = one.charAt(one.length()-1) + suffix;
			one = one.substring(0, one.length()-1);
			two = two.substring(0, two.length()-1);
		}
		
		String oneSuffix = suffix;
		if(one.length() > 0) {
			oneSuffix = recursiveHelper(one.substring(0, one.length()-1), two, suffix);
		}
		String twoSuffix = suffix;
		if(two.length() > 0) {
			twoSuffix = recursiveHelper(one, two.substring(0, two.length()-1), suffix);
		}
		 
		
		if(oneSuffix.length() > twoSuffix.length()) {
			return oneSuffix;
		}
		return twoSuffix;
	}
	
	public static String dynamic(String one, String two) {
		int[][] values = new int[one.length()+1][two.length()+1];
		
		for(int i = 1; i < one.length()+1; i++) {
			for(int j = 1; j < two.length()+1; j++) {
				if(one.charAt(i-1) == two.charAt(j-1)) {
					values[i][j] = values[i-1][j-1] + 1;
					continue;
				}
				
				values[i][j] = Math.max(values[i-1][j], values[i][j-1]);
			}
		}
		
		Utils.print2DArray(one, two, values);
		
		return "";
	}
	
	public static void main(String args[]) {
		String one = "ABDEFG";
		String two = "BCDGK";
		
		System.out.println(dynamic(one, two));
	}
}
