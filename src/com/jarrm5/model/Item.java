package com.jarrm5.model;

import com.jarrm5.constant.Condition;

public abstract class Item {
	
	private int itemNumber;
	private String itemName;
	private double weight;
	private Condition condition;
	
	public Item(String itemName) {
		this(itemName,0.0,null);
	}

	public Item(String itemName, double weight, Condition condition) {
		this.itemName = itemName;
		this.weight = weight;
		this.condition = condition;
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


	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}

	@Override
	public String toString() {
		return itemName + 
				"\nweight: " + weight + 
				"\ncondition: " + condition + 
				"\n";
	}

}
