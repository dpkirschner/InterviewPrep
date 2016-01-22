package com.kirscd.graph.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import com.kirscd.graph.Edge;
import com.kirscd.graph.GraphUtils;
import com.kirscd.graph.Node;

public class Dijkstra {
	public static int solve(ArrayList<Node> graph, Node start, Node target) {
		//this assumes we always want to find shortest path from the node in the 0 position in the array
		HashMap<Node, Integer> distances = generateDistances(graph);
		distances.put(start, 0);
		HashSet<Node> unseen = new HashSet<Node>(graph);
		
		while(unseen.size() > 0) {
			Node current = getMinimumValue(unseen, distances);
			unseen.remove(current);
			setMinimumDistance(current, distances);
		}
		
		return distances.get(target);
	}
	

	private static void setMinimumDistance(Node current, HashMap<Node, Integer> distances) {
		for(Edge edge : current.edges) {
			Node neighbor = edge.getNeighbor(current);
			distances.put(neighbor, Math.min(distances.get(current) + edge.weight, distances.get(neighbor)));
		}
	}


	private static Node getMinimumValue(HashSet<Node> unseen, HashMap<Node, Integer> distances) {
		Node toReturn = null;
		int minimum = Integer.MAX_VALUE;
		for(Node node : unseen)  {
			if(distances.get(node) <= minimum) {
				toReturn = node;
				minimum = distances.get(node);
			}
		}
		
		return toReturn;
	}


	/**
	 * @param graph
	 */
	private static HashMap<Node, Integer> generateDistances(ArrayList<Node> graph) {
		HashMap<Node, Integer> distances = new HashMap<Node, Integer>();
		for(Node node : graph) {
			distances.put(node, Integer.MAX_VALUE);
		}
		return distances;
	}
	
	public static void main(String args[]) {
		ArrayList<Node> graph = GraphUtils.buildWeightedGraph();
		System.out.println(solve(graph, graph.get(0), graph.get(3)));
	}
}
