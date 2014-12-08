package com.xmunch.atomspace.aux;

public enum VertexType {

	A {
		@Override
		public String get() {
			return "A";
		}
	},
	B {
		@Override
		public String get() {
			return "B";
		}
	},
	C {
		@Override
		public String get() {
			return "C";
		}
	},
	D {
		@Override
		public String get() {
			return "D";
		}
	},
	E {
		@Override
		public String get() {
			return "E";
		}
	},
	F {
		@Override
		public String get() {
			return "F";
		}
	};

	public abstract String get();
}
