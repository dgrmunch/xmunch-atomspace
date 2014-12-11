package com.xmunch.atomspace.model;

import com.xmunch.atomspace.aux.AtomType;


public class Vertex extends Atom {

	private String id;
	private String vertexType;
	private String atomType;
	private String vertexLabel;
	private String vertexParams;
	
	public Vertex(String id, String vertexType, String vertexLabel, String vertexParams) {
		this.id = id;
		this.vertexType = vertexType;
		this.vertexLabel = vertexLabel;
		this.vertexParams = vertexParams;
		this.atomType = AtomType.VERTEX.get();
		 
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

	public String getVertexParams() {
		return vertexParams;
	}

	public void setVertexParams(String vertexParams) {
		this.vertexParams = vertexParams;
	}

}
