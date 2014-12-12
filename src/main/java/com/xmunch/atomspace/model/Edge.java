package com.xmunch.atomspace.model;

import com.xmunch.atomspace.aux.AtomType;


public class Edge extends Atom {

	private String id;
	private String atomType;
	private String from;
	private String to;
	private String edgeLabel;
	private String edgeParams;
	
	public Edge(String id, String from, String to, String edgeLabel, String edgeParams) {
		this.id = id;
		this.from = from;
		this.to = to;
		this.setEdgeParams(edgeParams);
		this.edgeLabel = edgeLabel;
		this.atomType = AtomType.EDGE.get();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAtomType() {
		return atomType;
	}

	public void setAtomType(String atomType) {
		this.atomType = atomType;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getEdgeLabel() {
		return edgeLabel;
	}

	public void setEdgeLabel(String edgeLabel) {
		this.edgeLabel = edgeLabel;
	}

	public String getEdgeParams() {
		return edgeParams;
	}

	public void setEdgeParams(String edgeParams) {
		this.edgeParams = edgeParams;
	}

}
