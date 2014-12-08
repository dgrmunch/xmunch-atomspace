package com.xmunch.atomspace.model;

import com.xmunch.atomspace.aux.AtomType;


public class Vertex extends Atom {

	private String id;
	private String vertexType;
	private String atomType;
	private String vertexLabel;
	
	public Vertex(String id, String vertexType, String vertexLabel) {
		this.id = id;
		this.vertexType = vertexType;
		this.vertexLabel = vertexLabel;
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

	public String getVertexType() {
		return vertexType;
	}

	public void setVertexType(String vertexType) {
		this.vertexType = vertexType;
	}

	public String getVertexLabel() {
		return vertexLabel;
	}

	public void setVertexLabel(String vertexLabel) {
		this.vertexLabel = vertexLabel;
	}

}
