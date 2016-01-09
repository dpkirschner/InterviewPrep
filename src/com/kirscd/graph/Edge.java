package com.kirscd.graph;

import java.util.HashSet;
import java.util.Set;

public class Edge {
	public Set<Node> connections;
	public int weight;
	
	public Edge(Node one, Node two) {
		connections = new HashSet<Node>();
		connections.add(one);
		connections.add(two);
	}
	
	public Edge(Node one, Node two, int weight) {
		connections = new HashSet<Node>();
		connections.add(one);
		connections.add(two);
		this.weight = weight;
	}
	
	public Node getNeighbor(Node original) {
		if(!connections.contains(original)) {
			throw new IllegalArgumentException(
					String.format("This edge: %s doesn't contain that node: ", this, original));
		}
		
		for(Node node : connections) {
			if(node != original) {
				return node;
			}
		}
		
		throw new RuntimeException(
				String.format("This edge: %s was malformed", this));
	}
}
