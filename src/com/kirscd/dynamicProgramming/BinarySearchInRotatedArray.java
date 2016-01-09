package com.kirscd.dynamicProgramming;

public class BinarySearchInRotatedArray {
	public static int[] values = {4, 5, 1, 2, 3};
	
	public static int solve() {
		int lower = 0;
		int higher = values.length-1;
		int index = -1;
		while(lower <= higher) {
			int mid = (lower + higher) / 2; //2
			
			if(values[mid] > values[lower]) {
				lower = mid + 1;
				continue;
			} else if(values[mid] < values[lower]) {
				higher = mid;
				continue;
			} else {
				index = mid;
				break;
			}
		}
		
		return index;
		
		
	}
	
	public static void main(String args[]) {
		System.out.println(solve());
	}
}
