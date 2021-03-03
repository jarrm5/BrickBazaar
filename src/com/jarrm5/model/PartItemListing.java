package com.jarrm5.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.jarrm5.constant.Condition;
import com.jarrm5.constant.Gender;
import com.jarrm5.constant.ItemListingStatus;
import com.jarrm5.constant.PartItemCategory;
import com.jarrm5.constant.PartItemColor;
import com.jarrm5.constant.SetItemMinifigCategory;

public class PartItemListing extends ItemListing{
	
	private int quantity;

	public PartItemListing(double startingPrice, String notes, Item item,
			UserAccount seller, Condition condition, ItemListingStatus status, LocalDateTime closeTime,int quantity) {
		super(startingPrice,notes,item,seller,condition,status,closeTime);
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public static ArrayList<PartItemListing> getPartItemListings(){
		ArrayList<PartItemListing> listings = new ArrayList<PartItemListing>();
		listings.add(new PartItemListing(1.67,"Slight wear/stains.",new PartItem(2.10,2,2,2,PartItemCategory.SLOPE,PartItemColor.GREEN),new UserAccount("jrinella","password1","James","Rinella","ultimatemanlet66207@protonmail.com",LocalDate.of(1989,1,10),Gender.MALE),Condition.USED,ItemListingStatus.OPEN,LocalDateTime.now().plusDays(2).plusHours(12),5));
		listings.add(new PartItemListing(2.95,"Perfect condition.",new PartItem(2.10,3,1,-1,PartItemCategory.SLOPE,PartItemColor.RED),new UserAccount("mswan","password1","Meg","Swan",null,LocalDate.of(1970,10,11),Gender.FEMALE),Condition.NEW,ItemListingStatus.PENDING,LocalDateTime.now().plusDays(1).plusHours(4),10));
		return listings;
	}

	@Override
	public String toString() {
		return super.toString() + "quantity: " + this.quantity;
	}

}
