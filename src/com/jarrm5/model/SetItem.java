package com.jarrm5.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Predicate;

import com.jarrm5.constant.SetItemMinifigCategory;
import com.jarrm5.interfaces.Listable;
import com.jarrm5.interfaces.Relatable;

public class SetItem extends Item implements Listable, Relatable {
	
	public static int NUMBER_OF_SETITEMS = 0;
	
	private int nbrOfPieces;
	private String features;
	private SetItemMinifigCategory category;
	private LocalDate releaseDate;

	public SetItem(String itemName, double weight, int nbrOfPieces,String features,SetItemMinifigCategory category, LocalDate releaseDate) {
		super(category.getItemNumberPrefix() + ++NUMBER_OF_SETITEMS,itemName,weight);
		this.nbrOfPieces = nbrOfPieces;
		this.features = features;
		this.category = category;
		this.releaseDate = releaseDate;
	}

	public int getNbrOfPieces() {
		return nbrOfPieces;
	}

	public void setNbrOfPieces(int nbrOfPieces) {
		this.nbrOfPieces = nbrOfPieces;
	}

	public String getFeatures() {
		return features;
	}

	public void setFeatures(String features) {
		this.features = features;
	}

	public SetItemMinifigCategory getCategory() {
		return category;
	}

	public void setCategory(SetItemMinifigCategory category) {
		this.category = category;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	public static ArrayList<SetItem> getSetItems(){
		ArrayList<SetItem> setItemList = new ArrayList<SetItem>();
		setItemList.add(new SetItem("Majisto's Tower",415.9,179,"wizard's tower with wizard,2 guards and horse drawn cart",SetItemMinifigCategory.CASTLE,LocalDate.of(1994,3,1)));
		setItemList.add(new SetItem("Blacksmith Shop",825.1,616,"Structure opens to reveal interior",SetItemMinifigCategory.CASTLE,LocalDate.of(2002,6,30)));
		setItemList.add(new SetItem("Volcano Island",221.5,109,"Built in Volcano trap",SetItemMinifigCategory.PIRATE,LocalDate.of(1996,3,16)));
		setItemList.add(new SetItem("Lagoon Lockup",585.75,167,"Pirate Captain's boat, 4 minifigures",SetItemMinifigCategory.PIRATE,LocalDate.of(1991,10,7)));
		setItemList.add(new SetItem("X-Wing Fighter",767.0,414,"Cockpit opens, 1 rebel fighter minifigure",SetItemMinifigCategory.STAR_WARS,LocalDate.of(2006,2,19)));
		setItemList.add(new SetItem("AT-AT",2081.32,1052,"Side panels open to reveal interior, snowspeeder, snow trooper and 2 commander mini figures",SetItemMinifigCategory.STAR_WARS,LocalDate.of(2003,8,19)));
		return setItemList;
	}

	@Override
	public String toString() {
		return super.toString() + 
				"Piece count:" + nbrOfPieces + 
				"\ncategory: " + category + 
				"\nYear released: " + releaseDate.getYear() +
				"\n";
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
