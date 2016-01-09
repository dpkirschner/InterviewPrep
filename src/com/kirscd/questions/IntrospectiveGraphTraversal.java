package com.kirscd.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a graph of independent nodes, each with a list of their neighbors, write a method
 * which can be deployed on every node and, when run, will print the names of every node in the graph.
 */
public class IntrospectiveGraphTraversal {
	public static void main(String args[]) {
		runNoCycle();
		//runCycle();
		//runCycleWithDangle();
	}
	
	public static class Node implements Runnable {
		public ArrayList<Node> neighbors;
		public String name;
		private Set<Node> neighborsSeen;
		private Node lastSent;
		
		public Node(String name) {
			this.name = name;
			this.neighbors = new ArrayList<Node>();
			neighborsSeen = new HashSet<Node>();
			lastSent = null;
		}
		
		public void traversal(Set<String> book, Node sentFrom) {
			System.out.println(String.format("%s received it from %s", this.name, sentFrom == null ? "no one" : sentFrom.name));
			//sign the book
			if(!book.contains(this.name)) {
				book.add(this.name);
			}
			
			//if the book came from someone we didn't send it to, send it back immediately.
			//this prevents us from short circuiting when a cycle is present
			if(sentFrom != null && lastSent != null && sentFrom != lastSent) {
				sentFrom.traversal(book, this);
				return;
			}
			
			//if we know all of our neighbors have seen it
			//and we just got it back from the guy we last sent it to
			//we are done.
			if(neighborsSeen.size() == neighbors.size() && sentFrom == lastSent) {
				book.parallelStream().forEach(name -> { System.out.print(name + " -> ");});
				System.out.println();
				return;
			}
			
			//choose next node to send to
			
			Node next = nextNodeChoice(book, sentFrom);
			neighborsSeen.add(next);
			lastSent = next;
			next.traversal(book, this);
		}

		/**
		 * @param book
		 */
		private Node nextNodeChoice(Set<String> book, Node sentFrom) {
			for(Node node : neighbors) {
				//if we have nodes who haven't seen it yet that aren't the one we just got it from.
				if(!neighborsSeen.contains(node) && node != sentFrom) {
					
					
					return node;
				}
			}
			return sentFrom;
		}

		@Override
		public void run() {
			while(true);
			//System.out.println(this.name + " is alive!");
			
		}
	}
	
	
	private static void runNoCycle() {
		Node one = new Node("one");
		Node two = new Node("two");
		Node three = new Node("three");
		
		one.neighbors = new ArrayList<Node>(Arrays.asList(two));
		two.neighbors = new ArrayList<Node>(Arrays.asList(one, three));
		three.neighbors = new ArrayList<Node>(Arrays.asList(two));
		
		System.out.println("This should have nodes 1 - 3");
		one.traversal(new HashSet<String>(), null);
	}
	
	private static void runCycle() {
		Node one = new Node("one");
		Node two = new Node("two");
		Node three = new Node("three");
		
		one.neighbors = new ArrayList<Node>(Arrays.asList(two, three));
		two.neighbors = new ArrayList<Node>(Arrays.asList(three, one));
		three.neighbors = new ArrayList<Node>(Arrays.asList(one, two));
		
		System.out.println("This should have nodes 1 - 3");
		one.traversal(new HashSet<String>(), null);
	}

	private static void runCycleWithDangle() {
		Node one = new Node("one");
		Node two = new Node("two");
		Node three = new Node("three");
		Node four = new Node("four");
		
		one.neighbors = new ArrayList<Node>(Arrays.asList(two, three, four));
		two.neighbors = new ArrayList<Node>(Arrays.asList(one, three));
		three.neighbors = new ArrayList<Node>(Arrays.asList(one, two));
		four.neighbors = new ArrayList<Node>(Arrays.asList(one));
		
		System.out.println("This should have nodes 1 - 4");
		one.traversal(new HashSet<String>(), null);
	}

}
