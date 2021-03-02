package com.jarrm5.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Predicate;

import com.jarrm5.constant.SetItemMinifigCategory;
import com.jarrm5.interfaces.Listable;
import com.jarrm5.interfaces.Relatable;

public class MinifigItem extends Item {
	
	public static int NUMBER_OF_MINIFIGS = 0;
	
	private LocalDate releaseDate;
	private String description;
	private SetItemMinifigCategory category;
	private ArrayList<SetItem> setItemAppearsIn;

	public MinifigItem(String itemName, double weight, String description,LocalDate releaseDate,SetItemMinifigCategory category) {
		super(category.getItemNumberPrefix() + ++NUMBER_OF_MINIFIGS,itemName,weight);
		this.description = description;
		this.releaseDate = releaseDate;
		this.category = category;
	}
	
	public static ArrayList<MinifigItem> getMinifigList(){
		ArrayList<MinifigItem> minifigItemList = new ArrayList<MinifigItem>();
		minifigItemList.add(new MinifigItem("Majisto Wizard",4.4,"Majisto Wizard, Black Plastic Cape, brown satchel",LocalDate.of(1994,3,1),SetItemMinifigCategory.CASTLE));
		minifigItemList.add(new MinifigItem("Dragon Knight",4.1,"Light Gray Legs, Black Neck-Protector",LocalDate.of(1994,1,1),SetItemMinifigCategory.CASTLE));
		minifigItemList.add(new MinifigItem("Blacksmith",3.6,null,LocalDate.of(2002,11,1),SetItemMinifigCategory.CASTLE));
		minifigItemList.add(new MinifigItem("Pirate",3.8,"Pirate Brown Shirt, Black Leg with Peg Leg, Black Pirate Triangle Hat",LocalDate.of(1994,3,1),SetItemMinifigCategory.PIRATE));
		minifigItemList.add(new MinifigItem("Luke Skywalker",3.5,"Orange Pilot outfit",LocalDate.of(1999,7,1),SetItemMinifigCategory.STAR_WARS));
		minifigItemList.add(new MinifigItem("Snowtrooper",4.7,"Snowtrooper helmet, white armor",LocalDate.of(2003,12,1),SetItemMinifigCategory.STAR_WARS));
		return minifigItemList;
	}
	
	

	@Override
	public String toString() {
		return super.toString() + "released: " + releaseDate.getYear() + 
				"\ndescription: " + description + 
				"\ncategory: " + category.toString();
	}
}
