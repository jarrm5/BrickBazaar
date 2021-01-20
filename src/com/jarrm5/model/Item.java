package com.jarrm5.model;

public abstract class Item {
	
	private int itemNumber;
	private String itemName;
	private double weight;
	
	public Item(String itemName) {
		this(itemName,0.0);
	}

	public Item(String itemName, double weight) {
		this.itemName = itemName;
		this.weight = weight;
	}

	public int getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}


	@Override
	public String toString() {
		return itemName + 
				"\nweight: " + weight + 
				"\n";
	}

}
