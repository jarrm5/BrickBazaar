package com.jarrm5.constant;

public enum PartItemColor {
	RED,BLUE,GREEN,YELLOW,GREY,BLACK;
	
	public String toString() {
		switch(this) {
		case RED:
			return "Red";
		case BLUE:
			return "Blue";
		case GREEN:
			return "Green";
		case YELLOW:
			return "Yellow";
		case GREY:
			return "Grey";
		case BLACK:
			return "Black";
		default:
			return "No color specified";	
		}
	}
}
