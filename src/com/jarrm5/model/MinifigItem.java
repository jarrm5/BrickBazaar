package com.jarrm5.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Predicate;

import com.jarrm5.constant.SetItemMinifigCategory;
import com.jarrm5.interfaces.Listable;
import com.jarrm5.interfaces.Relatable;

public class MinifigItem extends Item implements Listable, Relatable {
	
	private LocalDate releaseDate;
	private SetItemMinifigCategory category;
	private ArrayList<SetItem> setItemAppearsIn;

	public MinifigItem(String itemName, LocalDate releaseDate, SetItemMinifigCategory category) {
		super(itemName);
		this.releaseDate = releaseDate;
		this.category = category;
	}

	@Override
	public int compareToOtherRelatable(Relatable other) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <Item> void listItem(Predicate<Item> test) {
		// TODO Auto-generated method stub

	}

	@Override
	public double computeListingPrice(Listable low, Listable high) {
		// TODO Auto-generated method stub
		return 0;
	}

}
