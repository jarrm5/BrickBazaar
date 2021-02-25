package com.jarrm5.model;

public abstract class Item {
	
	private String itemNumber;
	private String itemName;
	private double weight;
	
	protected Item(String itemNumber,String itemName, double weight) {
		this.itemNumber = itemNumber;
		this.itemName = itemName;
		this.weight = weight;
	}

	public String getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(String itemNumber) {
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
				"\n" + itemNumber +
				"\nweight: " + weight + 
				"\n";
	}

}
