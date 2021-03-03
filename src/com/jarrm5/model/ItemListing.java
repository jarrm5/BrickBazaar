package com.jarrm5.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.function.Predicate;

import com.jarrm5.constant.Condition;
import com.jarrm5.constant.Gender;
import com.jarrm5.constant.ItemListingStatus;
import com.jarrm5.constant.SetItemMinifigCategory;
import com.jarrm5.interfaces.Listable;

public abstract class ItemListing implements Listable{
	
	//Seperate out SetItem listings from the others.  Set Item listing has unique characteristics such as instructions included
	
	private static int NUMBER_OF_LISTINGS = 0;
	
	private int itemListingId;
	private double startingPrice;
	private String notes;
	private Item item;
	private UserAccount seller;
	private Condition condition;
	private ItemListingStatus status;
	private LocalDateTime dateTimeSubmitted;
	private LocalDateTime closeTime;

	public ItemListing(double startingPrice,String notes, Item item,
			UserAccount seller, Condition condition, ItemListingStatus status, LocalDateTime closeTime) {
		this.itemListingId = ++NUMBER_OF_LISTINGS;
		this.startingPrice = startingPrice;
		this.notes = notes;
		this.item = item;
		this.seller = seller;
		this.condition = condition;
		this.status = status;
		this.dateTimeSubmitted = LocalDateTime.now();
		this.closeTime = closeTime;
	}

	public int getItemListingId() {
		return itemListingId;
	}


	public void setItemListingId(int itemListingId) {
		this.itemListingId = itemListingId;
	}


	public double getStartingPrice() {
		return startingPrice;
	}


	public void setStartingPrice(double startingPrice) {
		this.startingPrice = startingPrice;
	}

	public String getNotes() {
		return notes;
	}


	public void setNotes(String notes) {
		this.notes = notes;
	}


	public Item getItem() {
		return item;
	}


	public void setItem(Item item) {
		this.item = item;
	}


	public UserAccount getSeller() {
		return seller;
	}


	public void setSeller(UserAccount seller) {
		this.seller = seller;
	}


	public Condition getCondition() {
		return condition;
	}


	public void setCondition(Condition condition) {
		this.condition = condition;
	}


	public ItemListingStatus getStatus() {
		return status;
	}


	public void setStatus(ItemListingStatus status) {
		this.status = status;
	}


	public LocalDateTime getDateTimeSubmitted() {
		return dateTimeSubmitted;
	}


	public void setDateTimeSubmitted(LocalDateTime dateTimeSubmitted) {
		this.dateTimeSubmitted = dateTimeSubmitted;
	}


	public LocalDateTime getCloseTime() {
		return closeTime;
	}


	public void setCloseTime(LocalDateTime closeTime) {
		this.closeTime = closeTime;
	}
	
	public String getItemListingTimeRemaining() {
		return String.valueOf(Period.between(LocalDate.now(),this.closeTime.toLocalDate()).getDays()) + " Days ";
	}
	
	@Override
	public String toString() {
		
		return  //item.getItemName() +
				"\nListing Id: " + itemListingId + 
				"\nPrice: $" + startingPrice + 
				"\nNotes: " + notes + 
				"\nSeller: " + seller.getUsername() + 
				"\nCondition: " + condition + 
				"\nStatus: " + status + 
				"\nDate Submitted: " + dateTimeSubmitted.format(DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mma")) + 
				"\nTime Remaining: " + getItemListingTimeRemaining()  + "\n";
	}
}
