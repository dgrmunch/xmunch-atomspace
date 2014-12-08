package com.xmunch.atomspace.model;

import com.xmunch.atomspace.aux.AtomType;


public class Edge extends Atom {

	private String id;
	private String edgeType;
	private String atomType;
	private String from;
	private String to;
	private String strength;
	private String edgeLabel;
	
	public Edge(String id, String from, String to, String strength, String edgeType, String edgeLabel) {
		this.id = id;
		this.from = from;
		this.to = to;
		this.strength = strength;
		this.edgeType = edgeType;
		this.edgeLabel = edgeLabel;
		this.atomType = AtomType.VERTEX.get();
		 
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEdgeType() {
		return edgeType;
	}

	public void setEdgeType(String edgeType) {
		this.edgeType = edgeType;
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

	public String getStrength() {
		return strength;
	}

	public void setStrength(String strength) {
		this.strength = strength;
	}

	public String getEdgeLabel() {
		return edgeLabel;
	}

	public void setEdgeLabel(String edgeLabel) {
		this.edgeLabel = edgeLabel;
	}

}
