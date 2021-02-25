package com.jarrm5.constant;

public enum SetItemMinifigCategory {
	STAR_WARS,CASTLE,PIRATE;
	
	public String getItemNumberPrefix() {
		switch(this) {
		case STAR_WARS:
			return "sw";
		case CASTLE:
			return "cas";
		case PIRATE:
			return "pi";
		default:
			return "";
		}
	}
	
	public String toString() {
		switch(this) {
		case STAR_WARS:
			return "Star Wars";
		case CASTLE:
			return "Castle";
		case PIRATE:
			return "Pirate";
		default:
			return "No category";
		}
	}
}
