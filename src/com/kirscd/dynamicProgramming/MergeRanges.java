package com.kirscd.dynamicProgramming;

import java.util.Arrays;

public class MergeRanges {
	public static Range[] values = {new Range(5, 13), new Range(27, 39), new Range(8,19), new Range(31, 37)};
	
	public static void solve() {
		for(int i = 0; i < values.length; i++) {
			if(values[i] != null) {
				for(int j = i + 1; j < values.length; j++) {
					if(values[j] != null && values[i].overlap(values[j])) {
						values[i].merge(values[j]);
						values[j] = null;
					}
				}
			}
		}
	}
	
	public static void main(String args[]) {
		Arrays.sort(values);
		for(Range range : values) {
			System.out.print(range + " -> ");
		}
		System.out.println();
		solve();
		for(Range range : values) {
			System.out.print(range + " -> ");
		}
	}
	
	
	private static class Range implements Comparable<Range> {
		public int low;
		public int high;
		
		public Range(int low, int high) {
			this.low = low;
			this.high = high;
		}
		
		public void merge(Range other) {
			this.low = Math.min(this.low, other.low);
			this.high = Math.max(this.high, other.high);
		}
		
		public boolean overlap(Range other) {
			return (other.low <= this.high && other.high >= this.high)
					|| (other.high >= this.low && other.low <= this.low)
					|| (this.low <= other.high && this.high >= other.high)
					|| (this.high >= other.low && this.low <= other.low);
		}
		
		public String toString() {
			return low + ":"+ high;
		}
		

		@Override
		public int compareTo(Range o) {
			if(this.low < o.low) {
				return -1;
			} else if (this.low > o.low) {
				return 1;
			}
			return 0;
		}
	}
}
