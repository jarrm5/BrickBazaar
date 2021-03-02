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

public class ItemListing implements Listable{
	
	//Seperate out SetItem listings from the others.  Set Item listing has unique characteristics such as instructions included
	
	private static int NUMBER_OF_LISTINGS = 0;
	
	private int itemListingId;
	private double startingPrice;
	private boolean instructionsIncluded;
	private int quantity;
	private String notes;
	
	private Item item;
	private UserAccount seller;
	private Condition condition;
	private ItemListingStatus status;
	private LocalDateTime dateTimeSubmitted;
	private LocalDateTime closeTime;

	public ItemListing(double startingPrice, boolean instructionsIncluded, int quantity, String notes, Item item,
			UserAccount seller, Condition condition, ItemListingStatus status, LocalDateTime closeTime) {
		this.itemListingId = ++NUMBER_OF_LISTINGS;
		this.startingPrice = startingPrice;
		this.instructionsIncluded = instructionsIncluded;
		this.quantity = quantity;
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


	public boolean isInstructionsIncluded() {
		return instructionsIncluded;
	}


	public void setInstructionsIncluded(boolean instructionsIncluded) {
		this.instructionsIncluded = instructionsIncluded;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
	
	public static ArrayList<ItemListing> getItemListings(){
		ArrayList<ItemListing> listings = new ArrayList<ItemListing>();
		listings.add(new ItemListing(60.00,true,1,"Never been opened and Complete with minifigs and instructions.",new SetItem("X-Wing Fighter",767.0,414,"Cockpit opens, 1 rebel fighter minifigure",SetItemMinifigCategory.STAR_WARS,LocalDate.of(2006,2,19)),new UserAccount("jrinella","password1","James","Rinella","ultimatemanlet66207@protonmail.com",LocalDate.of(1989,1,10),Gender.MALE),Condition.NEW,ItemListingStatus.OPEN,LocalDateTime.now().plusDays(2).plusHours(12)));
		listings.add(new ItemListing(299.00,false,1,"Set is complete and in good condition.  Minifigure has slight wear. No instructions",new SetItem("Blacksmith Shop",825.1,616,"Structure opens to reveal interior",SetItemMinifigCategory.CASTLE,LocalDate.of(2002,6,30)),new UserAccount("mswan","password1","Meg","Swan",null,LocalDate.of(1970,10,11),Gender.FEMALE),Condition.USED,ItemListingStatus.PENDING,LocalDateTime.now().plusDays(1).plusHours(4)));
		return listings;
	}
	
	@Override
	public String toString() {
		
		return  //item.getItemName() +
				"\nListing Id: " + itemListingId + 
				"\nPrice: $" + startingPrice + 
				"\nInstructions Included? " + instructionsIncluded + 
				"\nQuantity: " + quantity + 
				"\nNotes: " + notes + 
				"\nSeller: " + seller.getUsername() + 
				"\nCondition: " + condition + 
				"\nStatus: " + status + 
				"\nDate Submitted: " + dateTimeSubmitted.format(DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mma")) + 
				"\nTime Remaining: " + getItemListingTimeRemaining()  + "\n";
	}

	@Override
	public boolean listItem(Predicate<Item> tester) {
		return false;
	}

	@Override
	public double computeListingPrice(Listable low, Listable high) {
		// TODO Auto-generated method stub
		return 0;
	}

}
