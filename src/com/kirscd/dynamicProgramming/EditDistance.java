package com.kirscd.dynamicProgramming;

public class EditDistance {
	public static int MED(String a, String b) {
		int[][] arr = new int[a.length() + 1][b.length() + 1];
		
		for(int i = 0; i <= a.length(); i++) {
			arr[i][0] = i;
		}
		for(int j = 0; j <= b.length(); j++) {
			arr[0][j] = j;
		}
		
		
		for(int i = 1; i <= a.length(); i++) {
			for(int j = 1; j <= b.length(); j++) {
				int mine = 1;
				if(a.charAt(i-1) == b.charAt(j-1)) {
					mine = 0;
				}
				arr[i][j] = EditDistance.min(
						arr[i-1][j-1] + mine				 	//swap characters
						, arr[i-1][j] + 1					//insert character
						, arr[i][j-1] + 1);					//delete character
			}
		}
		for(int j = 0; j <= b.length(); j++) {
			if(j != 0) {
				System.out.print(b.charAt(j-1) + ":");
			} else {
				System.out.print("x -> ");
			}
		}
		for(int i = 0; i <= a.length(); i++) {
			if(i != 0) {
				System.out.print(a.charAt(i-1) + " -> ");
			} else {
				System.out.print("x -> ");
			}
			for(int j = 0; j <= b.length(); j++) {
				System.out.print(arr[i][j] + ":");
			}
			System.out.println();
		}
		
		return arr[a.length()][b.length()];
		
	}
	
	public static void main(String args[]) {
		System.out.println(MED("abcdefghijkl", "ljlkjlkjlkjbcdeffghixkl"));
	}
	
	public static int min(int a, int b, int c) {
		if(a <= b && a <= c) {
			return a;
		}
		if(b <= c && b <= a) {
			return b;
		}
		else {
			return c;
		}
	}
}
