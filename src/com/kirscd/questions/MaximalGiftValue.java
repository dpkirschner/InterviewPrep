package com.kirscd.questions;

/**
 * A board has n*m cells, and there is a gift with some value (value is greater than 0) in every cell.
 * You can get gifts starting from the top-left cell, and move right or down in each step, 
 * and finally reach the cell at the bottom-right cell. What’s the maximal value of gifts
 * you can get from the board?
 */
public class MaximalGiftValue {
	public static int[][] values = 
		{
			{1, 10, 3, 8},
			{12, 2, 9, 6},
			{5, 7, 4, 11},
			{3, 7, 16, 5},
		};
	
	public static int solve() {
		int[][] maxScores = new int[values.length][values[0].length];
		
		for(int i = 0; i < values.length; i++) {
			for(int j = 0; j < values[i].length; j++) {
				int fromAbove = values[i][j];
				if(i != 0) {
					fromAbove = fromAbove + maxScores[i-1][j];
				}

				int fromLeft = values[i][j];
				if(j != 0) {
					fromLeft = fromLeft + maxScores[i][j-1];
				}
				
				maxScores[i][j] = Math.max(fromAbove, fromLeft);
			}
		}
		
		for(int i = 0; i < values.length; i++) {
			for(int j = 0; j < values[i].length; j++) {
				System.out.print(maxScores[i][j] + " : ");
			}
			System.out.println();
		}	
		
		//return the bottom right square
		return maxScores[values.length-1][values[values.length-1].length-1];
	}
	
	public static void main(String args[]) {
		System.out.println(solve());
	}
}
