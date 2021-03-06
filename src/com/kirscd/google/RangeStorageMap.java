package com.kirscd.google;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Write a data structure which support storing multiple ranges of integers. It must also
 * have a contains method which will return true if a given integer is contained in any 
 * of the provided ranges.
 * 
 * This solution uses a SortedMap of Range objects to condense the given ranges into their smallest
 * form. IE if given the ranges 1-10 and 9-20 it will only contain a single range from 1-20. This
 * is only possible because I am abusing the natural ordering of Ranges with the compareTo() method.
 * If that doesn't make sense, read this blog post: 
 * http://www.danonrockstar.com/2015/12/the-difference-between-comparisons-and.html
 */
public class RangeStorageMap {
	private SortedMap<Range, Range> map;
	
	public RangeStorageMap() {
		map = new TreeMap<Range, Range>();
	}
	
	public boolean contains(int value) {
		return map.containsKey(new Range(value, value));
	}

    public void add(Range range) {
		//no matching ranges exist
    	Range existingRange = map.get(range);
    	if(existingRange == null) {
    		map.put(range, range);
    		return;
    	}
    	
		existingRange.merge(range);
    }
    
    public static void main(String args[]) {
    	Range[] ranges = {
    			new Range(0, 1)
    			, new Range(9, 10)
    			, new Range(4, 8)
    			, new Range(3, 5)
    			, new Range(10, 12)};
    	RangeStorageMap ranger = new RangeStorageMap();
    	for(Range range : ranges) {
    		ranger.add(range);
    	}
    	
    	System.out.println("Ranger contains 1: " + ranger.contains(1));
    	System.out.println("Ranger contains 2: " + ranger.contains(2));
    	System.out.println("Ranger contains 8: " + ranger.contains(8));
    	System.out.println("Ranger contains 9: " + ranger.contains(9));
    	System.out.println("Ranger contains 11: " + ranger.contains(11));
    	System.out.println("Ranger contains 13: " + ranger.contains(13));
    	System.out.println("fin");
    }
    
    public static class Range implements Comparable<Range> {
    	public int lowerBound;
    	public int upperBound;
    	
    	Range(int lowerBound, int upperBound) {
    		assert(lowerBound <= upperBound);
    		this.lowerBound = lowerBound;
    		this.upperBound = upperBound;
    	}
    	
    	public void merge(Range range) {
    		this.lowerBound = Math.min(this.lowerBound, range.lowerBound);
    		this.upperBound = Math.max(this.upperBound, range.upperBound);
    	}

    	@Override
    	public int compareTo(Range range) {
    		if(this.upperBound < range.lowerBound) {
    			return -1;
    		} else if(this.lowerBound > range.upperBound) {
    			return 1;
    		}
    		return 0;
    	}
    }

}
