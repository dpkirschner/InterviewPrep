package com.kirscd.graph.algorithms;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

import com.kirscd.graph.Edge;
import com.kirscd.graph.GraphUtils;
import com.kirscd.graph.Node;

public class Traversal {
	/**
	 * Standard breadth first search traversal. This will clean the nodes
	 * before and after the traversal to ensure we don't carry over any node
	 * state from previous/future runs
	 * @param graph
	 */
	public static void breadthFirstSearch(ArrayList<Node> graph) {
		System.out.println("BFS:");
		if(graph.size() == 0) {
			return;
		}
		
		GraphUtils.cleanGraph(graph);

		Queue<Node> queue = new LinkedList<Node>();
		for(Node node : graph) {
			if(node.state != Node.State.UNDISCOVERED) {
				continue;
			}
			node.state = Node.State.DISCOVERED;
			queue.add(node);
			
			while(!queue.isEmpty()) {
				node = queue.remove();
				
				//process node
				System.out.print(node.name + " -> ");
				
				for(Edge e : node.edges) {
					//process edge
					Node neighbor = e.getNeighbor(node);
					
					//first time we see this node it gets added to the queue for later processing
					if(neighbor.state == Node.State.UNDISCOVERED) {
						neighbor.state = Node.State.DISCOVERED;
						queue.add(neighbor);
					}
				}
				
				//finished with this node
				node.state = Node.State.COMPLETE;
			}
		}

		System.out.println();
		GraphUtils.cleanGraph(graph);
	}
	
	/**
	 * Standard depth first search iterative traversal. This will clean the nodes
	 * before and after the traversal to ensure we don't carry over any node
	 * state from previous/future runs
	 * @param graph
	 */
	public static void depthFirstSearchIterative(ArrayList<Node> graph) {
		System.out.println("DFS Iterative:");
		if(graph.size() == 0) {
			return;
		}
		
		GraphUtils.cleanGraph(graph);

		Deque<Node> stack = new ArrayDeque<Node>();
		for(Node node : graph) {
			if(node.state != Node.State.UNDISCOVERED) {
				continue;
			}
			node.state = Node.State.DISCOVERED;
			stack.push(node);
			while(!stack.isEmpty()) {
				node = stack.pop();
				
				//process node
				System.out.print(node.name + " -> ");
				
				for(Edge e : node.edges) {
					//process edge
					Node neighbor = e.getNeighbor(node);
					
					//first time we see this node it gets added to the stack for later processing
					if(neighbor.state == Node.State.UNDISCOVERED) {
						neighbor.state = Node.State.DISCOVERED;
						stack.push(neighbor);
					}
				}
				
				//finished with this node
				node.state = Node.State.COMPLETE;
			}
		}
		System.out.println();
		GraphUtils.cleanGraph(graph);
	}
	
	/**
	 * NOTE: The two implementations of DFS will show different results because of the 
	 * sequence of stack accesses. Recursive DFS always takes the first child to work with.
	 * Iterative DFS will always put all of the children on the stack first, then pop off the
	 * most recent one to work with. Same algorithm, just different sequence. Editing the Iterative
	 * DFS to put the children on the stack backwards will result in them having the same result.
	 * @param graph
	 */
	public static void depthFirstSearchRecursive(ArrayList<Node> graph) {
		System.out.println("DFS Recursive:");
		if(graph.size() == 0) {
			return;
		}
		
		GraphUtils.cleanGraph(graph);
		
		for(Node node : graph) {
			dfsRecursive(node);
		}
		
		System.out.println();
		
		GraphUtils.cleanGraph(graph);
	}

	/**
	 * Recursive helper for DFS algorithm
	 * @param graph
	 */
	private static void dfsRecursive(Node node) {
		//if the node state isn't undiscovered it has already been accounted for
		if(node == null || node.state != Node.State.UNDISCOVERED) {
			return;
		}
		node.state = Node.State.DISCOVERED;

		//process node
		System.out.print(node.name + " -> ");
		
		for(Edge e : node.edges) {
			dfsRecursive(e.getNeighbor(node));
		}
			
		//finished with this node
		node.state = Node.State.COMPLETE;
	}
	
	public static void main(String args[]) {
		ArrayList<Node> graph = GraphUtils.buildGraphWithCycle();
		Traversal.breadthFirstSearch(graph);
		Traversal.depthFirstSearchIterative(graph);
		Traversal.depthFirstSearchRecursive(graph);
	}
}
