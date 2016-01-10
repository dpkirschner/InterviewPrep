package com.kirscd.graph;

import java.util.ArrayList;

public class Node {
	public ArrayList<Edge> edges;
	public String name;
	public State state;
	private String toString;
	
	public Node(String name, ArrayList<Edge> edges) {
		this.name = name;
		this.edges = edges;
		this.state = State.UNDISCOVERED;
		this.toString = "node:" + this.name;
		this.edges = new ArrayList<Edge>();
	}
	
	public Node(String name) {
		this.name = name;
		this.state = State.UNDISCOVERED;
		this.toString = "node:" + this.name;
		this.edges = new ArrayList<Edge>();
	}
	
	public String toString() {
		return toString;
	}
	
	public enum State {
		//we haven't seen this node before
		UNDISCOVERED,
		//we are processing this node
		DISCOVERED,
		//this node is completely processed
		COMPLETE
	}
}
