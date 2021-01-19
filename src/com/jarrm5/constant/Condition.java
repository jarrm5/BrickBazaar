package com.jarrm5.constant;

public enum Condition {
	NEW, USED;
	
	public String toString() {
		switch(this) {
		case NEW:
			return "New";
		case USED:
			return "Used";
		default:
			return "Unknown";
		}
	}
}
