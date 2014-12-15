package com.xmunch.atomspace.aux;

public enum Globals {
	SELF {
		@Override
		public String get() {
			return "SELF";
		}
	},
	IS_A {
		@Override
		public String get() {
			return "is_a";
		}
	},
	SPACE {
		@Override
		public String get() {
			return " ";
		}
	},
	COMMA {
		@Override
		public String get() {
			return ",";
		}
	},
	JUMP {
		@Override
		public String get() {
			return "\n";
		}
	},
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
	THREE {
		@Override
		public String get() {
			return "3";
		}
	},
	HALF {
		@Override
		public String get() {
			return "0.5";
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
	}, VERTEX_ID_START_NUMBER {
		@Override
		public String get() {
			return "9000";
		}		
	},	HEX_GEN {
		@Override
		public String get() {
			return  "FF%06X";
		}
	},	SHARP {
		@Override
		public String get() {
			return  "#";
		}
	};
	
	public abstract String get();
}
