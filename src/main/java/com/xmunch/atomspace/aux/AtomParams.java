package com.xmunch.atomspace.aux;

public enum AtomParams {

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
	},
	STRENGTH {
		@Override
		public String get() {
			return "strength";
		}
	},
	FROM {
		@Override
		public String get() {
			return "from";
		}
	},
	TO {
		@Override
		public String get() {
			return "to";
		}
	}, 
	VERTEX_TYPE{
		@Override
		public String get() {
			return "vertex_type";
		}
	},
	VERTEX_LABEL{
		@Override
		public String get() {
			return "vertex_label";
		}
	}, 
	EDGE_TYPE{
		@Override
		public String get() {
			return "edge_type";
		}
	},
	EDGE_LABEL{
		@Override
		public String get() {
			return "edge_label";
		}
	}, VERTEX_PARAMS{
		@Override
		public String get() {
			return "vpar";
		}
	}, EDGE_PARAMS{
			@Override
			public String get() {
				return "epar";
			}
	};

	public abstract String get();
}
