package com.kirscd.algorithms;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * https://www.interviewcake.com/question/java/merging-ranges
 *
 */
public class MergingRanges {
	public static Meeting[] meetings = {
		new Meeting(0, 1)
		, new Meeting(9, 10)
		, new Meeting(4, 8)
		, new Meeting(3, 5)
		, new Meeting(10, 12)};
	
	public static ArrayList<Meeting> solve() {
		Arrays.sort(meetings);
		ArrayList<Meeting> condensed = new ArrayList<Meeting>();
		
		Meeting mine = meetings[0];
		for(int i = 1; i < meetings.length; i++) {
			if(mine.compareTo(meetings[i]) == 0) {
				mine = mine.merge(meetings[i]);
				continue;
			}
			condensed.add(mine);
			mine = meetings[i];
		}
		condensed.add(mine);
		
		return condensed;
	}
	
	public static void main(String args[]) {
		for(Meeting meeting : solve()) {
			System.out.print(meeting);
		}
		System.out.println();
	}
	
	public static class Meeting implements Comparable<Meeting> {

	    int startTime;
	    int endTime;

	    public Meeting(int startTime, int endTime) {
	        // number of 30 min blocks past 9:00 am
	        this.startTime = startTime;
	        this.endTime   = endTime;
	    }

	    public String toString() {
	        return String.format("(%d, %d)", startTime, endTime);
	    }
	    
	    public Meeting merge(Meeting other) {
	    	this.startTime = Math.min(this.startTime, other.startTime);
	    	this.endTime = Math.max(this.endTime, other.endTime);
	    	return this;
	    }

		@Override
		public int compareTo(Meeting o) {
			if(this.endTime < o.startTime) {
    			return -1;
    		} else if(this.startTime > o.endTime) {
    			return 1;
    		} 
    		
    		return 0;
		}
	}
}
