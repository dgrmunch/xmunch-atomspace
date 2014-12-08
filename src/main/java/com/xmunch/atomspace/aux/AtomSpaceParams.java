package com.xmunch.atomspace.aux;

public enum AtomSpaceParams {

	VISUALIZATION {
		@Override
		public String get() {
			return "visualization";
		}
	},
	PERSISTENCE {
		@Override
		public String get() {
			return "persistence";
		}
	};

	public abstract String get();
}
