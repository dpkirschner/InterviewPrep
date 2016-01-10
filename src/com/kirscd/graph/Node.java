package com.kirscd.graph;

import java.util.ArrayList;

public class Node {
	public ArrayList<Edge> edges;
	public String name;
	public State state;
	
	public Node(String name, ArrayList<Edge> edges) {
		this.name = name;
		this.edges = edges;
		this.state = State.UNDISCOVERED;
	}
	
	public Node(String name) {
		this.name = name;
		this.state = State.UNDISCOVERED;
	}
	
	public enum State {
		UNDISCOVERED,
		DISCOVERED,
		COMPLETE
	}
}
