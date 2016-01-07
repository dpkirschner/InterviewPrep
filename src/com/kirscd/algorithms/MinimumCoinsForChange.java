package com.kirscd.algorithms;

public class MinimumCoinsForChange {
	public static int[] coinValues = {1, 6, 10};
	
	public static int solve2(int value) {
		if(value == 0) {
			return 0;
		}
		
		int[] coinsNeeded = new int[value+1];
		for(int i = 1; i<coinsNeeded.length; i++) {
			coinsNeeded[i] = Integer.MAX_VALUE;
		}
		
		for(int i = 1; i <= value; i++) {
			for(int j = 0; j < coinValues.length; j++) {
				if(coinValues[j]<=i) {
					coinsNeeded[i] = Math.min(coinsNeeded[i], coinsNeeded[i-coinValues[j]] + 1);
				}
			}
			printArray(coinsNeeded);
		}
		
		return coinsNeeded[value];
	}
	
	public static int solve(int value) {
	    int[] minCoins = new int[value + 1];
	    for (int s = 1; s <= value; s++) {
	        minCoins[s] = Integer.MAX_VALUE - 1;
	    }

	    for (int s = 1; s <= value; s++) {
	        for (int coin : coinValues) {
	        	printArray(minCoins);
	            if (s >= coin) {
	                minCoins[s] = Math.min(minCoins[s], minCoins[s - coin] + 1);
	            }
	        }
	    }		    
	    
	    return minCoins[value];
	}

	/**
	 * @param minCoins
	 */
	private static void printArray(int[] minCoins) {
		for (int i : minCoins) {
		    System.out.print(i + " : ");
		}
		System.out.println();
	}
	
	public static int choices(int value, int count, int index) {
		if(value == 0 ) {
			return count;
		}
		if(index >= coinValues.length) {
			return Integer.MAX_VALUE;
		}
		
		int take = Integer.MAX_VALUE;
		
		if(value >= coinValues[index]) {
			take = choices(value - coinValues[index], count + 1, index);
		}
		
		int ignore = choices(value, count, index + 1);
		
		
		
		return Math.min(take, ignore);
	}
	
	public static void greedy(int value) {
		int total = value;
		for(int i = 0; i < coinValues.length; i++) {
			while(total >= coinValues[i]) {
				System.out.print(coinValues[i] + " : ");
				total = total - coinValues[i];
			}
		}
	}
	
	public static void main(String args[]) {
		//MinimumCoinsForChange.greedy(12);
		System.out.println(MinimumCoinsForChange.solve2(12));
	}
}
