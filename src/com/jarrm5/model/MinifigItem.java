package com.jarrm5.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Predicate;

import com.jarrm5.constant.SetItemMinifigCategory;
import com.jarrm5.interfaces.Listable;
import com.jarrm5.interfaces.Relatable;

public class MinifigItem extends Item implements Listable, Relatable {
	
	private LocalDate releaseDate;
	private String description;
	private SetItemMinifigCategory category;
	private ArrayList<SetItem> setItemAppearsIn;

	public MinifigItem(String itemName, String description,LocalDate releaseDate,SetItemMinifigCategory category) {
		super(itemName);
		this.description = description;
		this.releaseDate = releaseDate;
		this.category = category;
	}
	
	public static ArrayList<MinifigItem> getMinifigList(){
		ArrayList<MinifigItem> minifigItemList = new ArrayList<MinifigItem>();
		minifigItemList.add(new MinifigItem("Majisto Wizard","Majisto Wizard, Black Plastic Cape, brown satchel",LocalDate.of(1994,3,1),SetItemMinifigCategory.CASTLE));
		minifigItemList.add(new MinifigItem("Dragon Knight 1","Light Gray Legs, Black Neck-Protector",LocalDate.of(1994,1,1),SetItemMinifigCategory.CASTLE));
		minifigItemList.add(new MinifigItem("Blacksmith 2",null,LocalDate.of(2002,11,1),SetItemMinifigCategory.CASTLE));
		minifigItemList.add(new MinifigItem("Pirate","Pirate Brown Shirt, Black Leg with Peg Leg, Black Pirate Triangle Hat",LocalDate.of(1994,3,1),SetItemMinifigCategory.PIRATE));
		minifigItemList.add(new MinifigItem("Luke Skywalker","Orange Pilot outfit",LocalDate.of(1999,7,1),SetItemMinifigCategory.STAR_WARS));
		minifigItemList.add(new MinifigItem("Snowtrooper","Snowtrooper helmet, white armor",LocalDate.of(2003,12,1),SetItemMinifigCategory.STAR_WARS));
		return minifigItemList;
	}
	
	

	@Override
	public String toString() {
		return super.toString() + "released: " + releaseDate.getYear() + 
				"\ndescription: " + description + 
				"\ncategory: " + category.toString();
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
