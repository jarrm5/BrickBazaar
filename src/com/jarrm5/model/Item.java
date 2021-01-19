package com.jarrm5.model;

import com.jarrm5.constant.Condition;

public abstract class Item {
	
	private int itemNumber;
	private String itemName;
	private double weight;
	private String description;
	private Condition condition;
	
	public Item(String itemName) {
		this(itemName,0.0,null,null);
	}

	public Item(String itemName, double weight, String description, Condition condition) {
		this.itemName = itemName;
		this.weight = weight;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}

}
