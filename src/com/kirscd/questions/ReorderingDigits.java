package com.kirscd.questions;

/**
 * Reorder the digits of a number, in order to get the next number
 *  which is the least one that is greater than the input number. 
 *  For example, the number 34724126 is the next number of 
 *  34722641 when reordering digits.
 *
 */
public class ReorderingDigits {
	public static int[] values = {8,9,8,7,6,5,4,3,2,1};
	
	public static int[] solve() {
		int[] mine = new int[values.length];
		for(int i = 0; i < mine.length; i++) {
			mine[i] = values[i];
		}
		
		int checkpoint = mine[mine.length - 1];
		int last = mine[mine.length - 1];
		int index = mine.length-1;
		for(int i = mine.length-1; i >= 0; i--) {
			if(mine[i] < last) {
				checkpoint = mine[i];
				index = i;
				break;
			} else {
				last = mine[i];
			}
		}
		
		int max = Integer.MAX_VALUE;
		int toSwap = -1;
		for(int i = index; i < mine.length; i++) {
			if(mine[i] < max && mine[i] > checkpoint) {
				max = mine[i];
				toSwap = i;
			}
		}
		
		int tmp = mine[toSwap];
		mine[toSwap] = mine[index];
		mine[index] = tmp;
		
		//sort from index+1 to mine.length-1 in increasing order
		index = index + 1;
		while(index < mine.length) {
			int min = index;
			for(int i = index; i<mine.length; i++) {
				if(mine[i] < mine[min]) {
					min = i;
				}
			}
			tmp = mine[min];
			mine[min] = mine[index];
			mine[index] = tmp;
			index++;
		}
		
		return mine;
	}
	
	public static void main(String args[]) {
		int[] mine = solve();
		for(int i : mine) {
			System.out.print(i);
		}
	}
}
