package com.kirscd.graph.algorithms;

import java.util.ArrayList;

import com.kirscd.graph.Edge;
import com.kirscd.graph.GraphUtils;
import com.kirscd.graph.Node;

public class ContainsCycle {
	
	/**
	 * returns true if the given graph contains a cycle
	 * @param graph
	 */
	public static boolean containsCycle(ArrayList<Node> graph) {
		if(graph.size() == 0) {
			return false;
		}
		
		GraphUtils.cleanGraph(graph);
		
		//iterate over every node to make sure we pick up any unconnected nodes
		for(Node node : graph) {
			//this node has already been marked in a previous sweep so ignore
			if(node.state != Node.State.UNDISCOVERED) {
				continue;
			} else if(containsCycleHelper(node)) {
				return true;
			}
		}

		GraphUtils.cleanGraph(graph);
		return false;
	}

	/**
	 * Recursive helper for contains Cycle implementation
	 * @param graph
	 */
	private static boolean containsCycleHelper(Node node) {
		//if the node state isn't undiscovered it has already been accounted for
		if(node.state != Node.State.UNDISCOVERED) {
			return true;
		}
		
		node.state = Node.State.DISCOVERED;
		
		for(Edge edge : node.edges) {
			//if this edge is a tree edge, ignore it since that is how we got here
			if(edge.state == Edge.State.TREE) {
				continue;
			}
			edge.state = Edge.State.TREE;
			if(containsCycleHelper(edge.getNeighbor(node))) {
				return true;
			}
		}
			
		//finished with this node
		node.state = Node.State.COMPLETE;
		return false;
	}
	
	public static void main(String args[]) {
		System.out.println(ContainsCycle.containsCycle(GraphUtils.buildGraphWithCycle()));
		System.out.println(ContainsCycle.containsCycle(GraphUtils.buildGraphTree()));
	}
}
