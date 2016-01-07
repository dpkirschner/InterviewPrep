package com.kirscd.algorithms;

public class LongestCommonSubString {
	public static String solve(String a, String b) {
		int[][] mine = generateArray(a, b);
		
		for(int i = 1; i<=a.length(); i++) {
			for(int j = 1; j<=b.length(); j++) {
				if(a.charAt(i-1) == b.charAt(j-1)) {
					mine[i][j] = mine[i-1][j-1] + 1;
				} else {
					mine[i][j] = 0;
				}
			}
		}
		
		printArray(mine, a, b);
		
		String longest = findLongestSubString(mine, a, b);
		
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
		//row -1 is character it ends at.
		//1789 23456
		for(int i = row + 1 - values[row][column]; i <= values[row][column]; i++) {
			sb.append(a.charAt(i));
		}
		
		return sb.toString();
	}
	
	public static void main(String args[]) {
		System.out.println(LongestCommonSubString.solve("abcdjfghijkl", "ljlkjlkjlkjbcdeffghixkl"));
	}

	/**
	 * @param a
	 * @param b
	 */
	private static void printArray(int[][] values, String a, String b) {
		for(int j = 0; j <= b.length(); j++) {
			if(j != 0) {
				System.out.print(b.charAt(j-1) + ":");
			} else {
				System.out.print("x ->   ");
			}
		}
		System.out.println();
		for(int i = 0; i <= a.length(); i++) {
			if(i != 0) {
				System.out.print(a.charAt(i-1) + " -> ");
			} else {
				System.out.print("x -> ");
			}
			for(int j = 0; j <= b.length(); j++) {
				System.out.print(values[i][j] + ":");
			}
			System.out.println();
		}
	}

	/**
	 * @param a
	 * @param b
	 */
	private static int[][] generateArray(String a, String b) {
		int[][] mine = new int[a.length()+1][b.length()+1];
		
		for(int i = 0; i <= a.length(); i++) {
			for(int j = 0; j <= b.length(); j++) {
				mine[i][j] = 0;
			}
		}

		
		return mine;
	}
}
