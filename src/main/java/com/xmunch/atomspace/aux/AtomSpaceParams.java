package com.xmunch.atomspace.aux;

public enum AtomSpaceParams {
	SELF {
		@Override
		public String get() {
			return "self";
		}
	},
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
