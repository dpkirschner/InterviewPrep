package com.kirscd.dynamicProgramming;

import com.kirscd.utilities.Utils;

public class LongestCommonSubString {
	public static String solve(String a, String b) {
		int[][] values = new int[a.length()+1][b.length()+1];
		
		for(int i = 1; i<=a.length(); i++) {
			for(int j = 1; j<=b.length(); j++) {
				if(a.charAt(i-1) == b.charAt(j-1)) {
					values[i][j] = values[i-1][j-1] + 1;
					continue;
				}
				values[i][j]=0;
			}
		}
		
		Utils.print2DArray(a, b, values);
		
		String longest = findLongestSubString(values, a, b);
		
		return longest;
	}
	
	private static String findLongestSubString(int[][] values, String a, String b) {
		int row = 0;
		int column = 0;
		for(int i = 1; i <= a.length(); i++) {
			for(int j = 1; j <= b.length(); j++) {
				if(values[i][j] > values[row][column]) {
					row = i;
					column = j;
				}
			}
		}
		
		if(row == 0 && column == 0) {
			return "";
		}
		
		StringBuilder sb = new StringBuilder();
		System.out.println(row + " : " + column);
		for(int i = row + 1 - values[row][column]; i <= values[row][column]; i++) {
			sb.append(a.charAt(i));
		}
		
		return sb.toString();
	}
	
	public static void main(String args[]) {
		System.out.println(LongestCommonSubString.solve("abcdjfghijkl", "ljlkjlkjlkjbcdeffghixkl"));
	}
}
