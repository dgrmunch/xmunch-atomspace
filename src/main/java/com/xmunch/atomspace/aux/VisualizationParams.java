package com.xmunch.atomspace.aux;

public enum VisualizationParams {

	SIZE {
		@Override
		public String get() {
			return "size";
		}
	},
	COLOR {
		@Override
		public String get() {
			return "color";
		}
	},
	SHAPE {
		@Override
		public String get() {
			return "shape";
		}
	},
	LABEL {
		@Override
		public String get() {
			return "label";
		}
	},
	ARROW {
		@Override
		public String get() {
			return "arrow";
		}
	},
	STROKE {
		@Override
		public String get() {
			return "stroke";
		}
	},
	WIDTH {
		@Override
		public String get() {
			return "width";
		}
	},
	SPHERE {
		@Override
		public String get() {
			return "sphere";
		}
	},
	CONE {
		@Override
		public String get() {
			return "cone";
		}
	},
	DASHED {
		@Override
		public String get() {
			return "dashed";
		}
	};

	public abstract String get();
}
