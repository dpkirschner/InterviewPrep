package com.kirscd.graph.algorithms;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

import com.kirscd.graph.Edge;
import com.kirscd.graph.Node;

public class Traversal {
	/**
	 * This is a destructive BFS. It marks the nodes during traversal and as such will
	 * need the graph to be cleaned (by setting each nodes state to undiscovered)
	 * between each run
	 * @param graph
	 */
	public static void breadthFirstSearch(ArrayList<Node> graph) {
		System.out.println("BFS:");
		if(graph.size() == 0) {
			return;
		}

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
	}
	
	/**
	 * This is a destructive DFS. It marks the nodes during traversal and as such will
	 * need the graph to be cleaned (by setting each nodes state to undiscovered)
	 * between each run
	 * @param graph
	 */
	public static void depthFirstSearchIterative(ArrayList<Node> graph) {
		System.out.println("DFS Iterative:");
		if(graph.size() == 0) {
			return;
		}

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
			System.out.println();
		}
		
	}
	
	/**
	 * This is a destructive DFS. It marks the nodes during traversal and as such will
	 * need the graph to be cleaned (by setting each nodes state to undiscovered)
	 * between each run.
	 * 
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
		
		dfsRecursive(graph.get(0));
		System.out.println();
	}

	/**
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
			//process edge
			Node neighbor = e.getNeighbor(node);
			
			//first time we see this node it gets added to the stack for later processing
			dfsRecursive(neighbor);
		}
			
		//finished with this node
		node.state = Node.State.COMPLETE;
	}
	
	public static void main(String args[]) {
		Traversal.breadthFirstSearch(buildGraph());
		Traversal.depthFirstSearchIterative(buildGraph());
		Traversal.depthFirstSearchRecursive(buildGraph());
	}

	/**
	 * Returns a set of Nodes which have different relationships
	 */
	private static ArrayList<Node> buildGraph() {
		Node one = new Node("one");
		Node two = new Node("two");
		Node three = new Node ("three");
		Node four = new Node("four");
		Node five = new Node("five");
		Node six = new Node("six");
		
		Edge oneTwo = new Edge(one, two);
		Edge oneFive = new Edge(one, five);
		Edge oneSix = new Edge(one, six);
		
		Edge twoThree = new Edge(two, three);
		Edge twoFive = new Edge(two, five);
		
		Edge threeFour = new Edge(three, four);
		
		Edge fourFive = new Edge(four, five);
		
		ArrayList<Edge> oneEdges = new ArrayList<Edge>(Arrays.asList(oneTwo, oneFive, oneSix));
		one.edges = oneEdges;
		ArrayList<Edge> twoEdges = new ArrayList<Edge>(Arrays.asList(oneTwo, twoThree, twoFive));
		two.edges = twoEdges;
		ArrayList<Edge> threeEdges = new ArrayList<Edge>(Arrays.asList(twoThree, threeFour));
		three.edges = threeEdges;
		ArrayList<Edge> fourEdges = new ArrayList<Edge>(Arrays.asList(threeFour, fourFive));
		four.edges = fourEdges;
		ArrayList<Edge> fiveEdges = new ArrayList<Edge>(Arrays.asList(oneFive, twoFive, fourFive));
		five.edges = fiveEdges;
		ArrayList<Edge> sixEdges = new ArrayList<Edge>(Arrays.asList(oneSix));
		six.edges = sixEdges;
		
		return new ArrayList<Node>(Arrays.asList(one, two, three, four, five, six));
	}
}
