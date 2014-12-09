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
	},
	RED {
		@Override
		public String get() {
			return "#FF3300";
		}
	},
	BLUE {
		@Override
		public String get() {
			return "#00CCFF";
		}
	},
	GREEN {
		@Override
		public String get() {
			return "#00FF00";
		}
	},
	YELLOW {
		@Override
		public String get() {
			return "#FFFF00";
		}
	},
	PINK {
		@Override
		public String get() {
			return "#FF00FF";
		}
	},
	WHITE {
		@Override
		public String get() {
			return "#FFFFFF";
		}
	}, RPC_SERVER{
		@Override
		public String get() {
			return "http://127.0.0.1:20738/RPC2";
		}		
	};

	public abstract String get();
}
