package com.jarrm5.constant;

public enum SetItemCategory {
	STAR_WARS,CASTLE,PIRATE;
	
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
