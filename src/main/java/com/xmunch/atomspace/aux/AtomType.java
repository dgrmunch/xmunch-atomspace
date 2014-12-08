package com.xmunch.atomspace.aux;

public enum AtomType {

	VERTEX {
		@Override
		public String get() {
			return "vertex";
		}
	},
	EDGE {
		@Override
		public String get() {
			return "edge";
		}
	};

	public abstract String get();
}
