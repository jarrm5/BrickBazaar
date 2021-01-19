package com.jarrm5.model;

import java.time.LocalDateTime;
import java.util.function.Predicate;

import com.jarrm5.constant.Condition;
import com.jarrm5.constant.ItemSetCategory;
import com.jarrm5.interfaces.Listable;
import com.jarrm5.interfaces.Relatable;

public class Set extends Item implements Listable, Relatable {
	
	private int nbrOfPieces;
	private boolean instructionsIncluded;
	private ItemSetCategory category;
	private LocalDateTime releaseDate;

	public Set(String itemName) {
		super(itemName);
	}

	public Set(String itemName, double weight, String description, Condition condition) {
		super(itemName, weight, description, condition);
	}

	public int getNbrOfPieces() {
		return nbrOfPieces;
	}

	public void setNbrOfPieces(int nbrOfPieces) {
		this.nbrOfPieces = nbrOfPieces;
	}

	public boolean isInstructionsIncluded() {
		return instructionsIncluded;
	}

	public void setInstructionsIncluded(boolean instructionsIncluded) {
		this.instructionsIncluded = instructionsIncluded;
	}

	public ItemSetCategory getCategory() {
		return category;
	}

	public void setCategory(ItemSetCategory category) {
		this.category = category;
	}

	public LocalDateTime getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDateTime releaseDate) {
		this.releaseDate = releaseDate;
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

}
