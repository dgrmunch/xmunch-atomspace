package com.xmunch.atomspace.model;

import com.xmunch.atomspace.aux.AtomType;

public class Atom {
	private Integer id;
	private AtomType atomType;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public AtomType getAtomType() {
		return atomType;
	}
	public void setAtomType(AtomType atomType) {
		this.atomType = atomType;
	}
}
