package com.kirscd.questions;

/**
 * Given a sorted array of length N, find the number which occurs more than N/4 times.
 *
 */
public class FindRepeatedInteger {
	public static int[] values = {1, 2, 2, 2, 3, 4, 4, 4, 5, 5, 6, 6};
	
	public static int solve() {
		int interval = values.length/4;
		
		int lower = 0;
		int higher = interval;
		int mark = values[higher];
		
		while(lower < higher && higher < values.length) {
			if(values[lower] == mark) {
				return mark;
			}
			int left = binarySearch(lower, higher, mark, true);
			int right = binarySearch(higher, Math.min(values.length - 1, higher+interval+1), mark, false);
			//add one here to account for the fact that arrays are 0 based
			if(right - left + 1 > interval) {
				return values[right];
			}
			lower = right;
			higher = Math.min(values.length - 1, right + interval + 1);
			mark = values[higher];
		}
		
		return -1;
	}
	
	public static int binarySearch(int lower, int higher, int mark, boolean lookLeft) {
		int mid = (lower + higher) / 2;
		if(isFirstOrLastOccurence(mark, mid, lookLeft)) {
			return mid;
		} else if(values[mid] < mark) {
			return binarySearch(mid + 1, higher, mark, lookLeft);
		} else if (values[mid] > mark) {
			return binarySearch(lower, mid, mark, lookLeft);
		} else  {
			//mark is the value we are looking for, but it isn't the last occurrence (either right or left)
			if(lookLeft) {
				return binarySearch(lower, mid, mark, lookLeft);
			} 
			
			return binarySearch(mid + 1, higher, mark, lookLeft);
		}
	}

	/**
	 * @param mark
	 * @param mid
	 * @return
	 */
	private static boolean isFirstOrLastOccurence(int mark, int mid, boolean lookLeft) {
		if(lookLeft) {
			return values[mid] == mark && (mid - 1 < 0 || values[mid - 1] < mark);
		}
		return values[mid] == mark && (mid + 1 >= values.length || values[mid + 1] > mark);
	}
	
	public static void main(String args[]) {
		System.out.println(solve());
	}
}
