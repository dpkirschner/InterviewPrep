package com.kirscd.graph.algorithms;

import java.util.ArrayList;

import com.kirscd.graph.Edge;
import com.kirscd.graph.GraphUtils;
import com.kirscd.graph.Node;

public class Connected {
	
	/**
	 * returns true if the given graph is completely connected (no unconnected sub-graphs)
	 * @param graph
	 */
	public static boolean isConnected(ArrayList<Node> graph) {
		if(graph.size() == 0) {
			return true;
		}
		
		GraphUtils.cleanGraph(graph);
		
		//mark all the nodes we can reach from the first one
		dfsMarkNodes(graph.get(0));
		for(Node node : graph) {
			//this node has already been marked in a previous sweep so ignore
			if(node.state != Node.State.COMPLETE) {
				return false;
			}
		}

		GraphUtils.cleanGraph(graph);
		return true;
	}

	/**
	 * Recursive helper for isConnected implementation
	 * @param graph
	 */
	private static void dfsMarkNodes(Node node) {
		//if the node state isn't undiscovered it has already been accounted for
		if(node.state != Node.State.UNDISCOVERED) {
			return;
		}
		
		//mark this node
		node.state = Node.State.DISCOVERED;
		
		for(Edge edge : node.edges) {
			dfsMarkNodes(edge.getNeighbor(node));
		}
			
		//finished with this node
		node.state = Node.State.COMPLETE;
	}
	
	public static void main(String args[]) {
		System.out.println(Connected.isConnected(GraphUtils.buildGraphWithCycle()));
		System.out.println(Connected.isConnected(GraphUtils.buildGraphTree()));
		System.out.println(Connected.isConnected(GraphUtils.buildUnconnectedGraph()));
	}
}
