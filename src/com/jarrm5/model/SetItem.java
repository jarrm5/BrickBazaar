package com.jarrm5.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.function.Predicate;

import com.jarrm5.constant.Condition;
import com.jarrm5.constant.SetItemCategory;
import com.jarrm5.interfaces.Listable;
import com.jarrm5.interfaces.Relatable;

public class SetItem extends Item implements Listable, Relatable {
	
	private int nbrOfPieces;
	private String features;
	private boolean instructionsIncluded;
	private SetItemCategory category;
	private LocalDate releaseDate;

	public SetItem(String itemName) {
		super(itemName);
	}

	public SetItem(String itemName, double weight, Condition condition) {
		super(itemName,weight,condition);
	}
	
	public SetItem(String itemName, double weight,Condition condition, int nbrOfPieces, String features,boolean instructionsIncluded, SetItemCategory category, LocalDate releaseDate) {
		super(itemName,weight,condition);
		this.nbrOfPieces = nbrOfPieces;
		this.features = features;
		this.instructionsIncluded = instructionsIncluded;
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

	public boolean isInstructionsIncluded() {
		return instructionsIncluded;
	}

	public void setInstructionsIncluded(boolean instructionsIncluded) {
		this.instructionsIncluded = instructionsIncluded;
	}

	public SetItemCategory getCategory() {
		return category;
	}

	public void setCategory(SetItemCategory category) {
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
		setItemList.add(new SetItem("Majisto's Tower",415.9,Condition.USED,179,"wizard's tower with wizard,2 guards and horse drawn cart",true,SetItemCategory.CASTLE,LocalDate.of(1994,3,1)));
		setItemList.add(new SetItem("Blacksmith Shop",825.1,Condition.NEW,616,"Structure opens to reveal interior",true,SetItemCategory.CASTLE,LocalDate.of(2002,6,30)));
		setItemList.add(new SetItem("Volcano Island",221.5,Condition.NEW,109,"Built in Volcano trap",true,SetItemCategory.PIRATE,LocalDate.of(1996,3,16)));
		setItemList.add(new SetItem("Lagoon Lockup",585.75,Condition.USED,167,"Pirate Captain's boat, 4 minifigures",false,SetItemCategory.PIRATE,LocalDate.of(1991,10,7)));
		setItemList.add(new SetItem("X-Wing Fighter",767.0,Condition.USED,414,"Cockpit opens, 1 rebel fighter minifigure",false,SetItemCategory.STAR_WARS,LocalDate.of(2006,2,19)));
		setItemList.add(new SetItem("AT-AT",2081.32,Condition.NEW,1052,"Side panels open to reveal interior, snowspeeder, snow trooper and 2 commander mini figures",false,SetItemCategory.STAR_WARS,LocalDate.of(2003,8,19)));
		return setItemList;
	}

	@Override
	public String toString() {
		return super.toString() + 
				"Piece count:" + nbrOfPieces + 
				"\nInstructions included? " + (instructionsIncluded ? "Yes" : "No") + 
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
