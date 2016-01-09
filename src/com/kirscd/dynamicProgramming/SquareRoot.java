package com.kirscd.dynamicProgramming;

public class SquareRoot {
	public static int solve(int root) {
		return solve(root, 0, root);
	}
	
	public static int solve(int root, int lower, int higher) {
		if(higher <= lower || higher - 1 <= lower) {
			return higher;
		}
		int mid = (lower + higher)/2;
		
		int newGuess = mid*mid;
		if(newGuess > root) {
			return solve(root, lower, mid);
		} else if(newGuess == root) {
			return mid;
		}
		return solve(root, mid, higher);
	}
	
	public static void main(String args[]) {
		System.out.println(solve(5));
	}
}
