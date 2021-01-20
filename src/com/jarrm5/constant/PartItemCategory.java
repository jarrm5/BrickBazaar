package com.jarrm5.constant;

public enum PartItemCategory {
	BRICK,PLATE,SLOPE,OTHER;
	
	public String toString() {
		switch(this) {
		case BRICK:
			return "Brick";
		case PLATE:
			return "Plate";
		case SLOPE:
			return "Slope";
		default:
			return "No category";
		}
	}
}
