package com.jarrm5.model;

import com.jarrm5.interfaces.Relatable;

//Represents an Item that cannot be bid on and only meant for showing off

public class ItemNotForSale extends Item implements Relatable {

	public ItemNotForSale(String itemName) {
		super(itemName);
		// TODO Auto-generated constructor stub
	}

	public ItemNotForSale(String itemName, double weight) {
		super(itemName, weight);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compareToOtherRelatable(Relatable other) {
		// TODO Auto-generated method stub
		return 0;
	}

}
