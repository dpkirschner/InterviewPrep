package com.kirscd.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class GraphUtils {
	/**
	 * Returns a set of Nodes which have different relationships
	 */
	public static ArrayList<Node> buildGraphWithCycle() {
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
	
	/**
	 * Returns a set of Nodes which have different relationships
	 */
	public static ArrayList<Node> buildGraphTree() {
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
		
		Edge fourFive = new Edge(four, five);
		
		ArrayList<Edge> oneEdges = new ArrayList<Edge>(Arrays.asList(oneTwo, oneFive, oneSix));
		one.edges = oneEdges;
		ArrayList<Edge> twoEdges = new ArrayList<Edge>(Arrays.asList(oneTwo, twoThree));
		two.edges = twoEdges;
		ArrayList<Edge> threeEdges = new ArrayList<Edge>(Arrays.asList(twoThree));
		three.edges = threeEdges;
		ArrayList<Edge> fourEdges = new ArrayList<Edge>(Arrays.asList(fourFive));
		four.edges = fourEdges;
		ArrayList<Edge> fiveEdges = new ArrayList<Edge>(Arrays.asList(oneFive, fourFive));
		five.edges = fiveEdges;
		ArrayList<Edge> sixEdges = new ArrayList<Edge>(Arrays.asList(oneSix));
		six.edges = sixEdges;
		
		return new ArrayList<Node>(Arrays.asList(one, two, three, four, five, six));
	}
	

	/**
	 * This will clean the nodes to ensure we don't carry over any node
	 * state from previous/future traversals
	 * @param graph
	 */
	public static void cleanGraph(ArrayList<Node> graph) {
		for(Node node : graph) {
			node.state = Node.State.UNDISCOVERED;
		}
	}
}
