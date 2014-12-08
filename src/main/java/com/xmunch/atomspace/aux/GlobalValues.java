package com.xmunch.atomspace.aux;

public enum GlobalValues {

	TRUE {
		@Override
		public String get() {
			return "true";
		}
	},
	FALSE {
		@Override
		public String get() {
			return "false";
		}
	},
	ONE {
		@Override
		public String get() {
			return "1";
		}
	};

	public abstract String get();
}
