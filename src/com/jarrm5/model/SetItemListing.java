package com.jarrm5.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.function.Predicate;

import com.jarrm5.constant.Condition;
import com.jarrm5.constant.Gender;
import com.jarrm5.constant.ItemListingStatus;
import com.jarrm5.constant.SetItemMinifigCategory;
import com.jarrm5.interfaces.Listable;

public class SetItemListing extends ItemListing{
	
	private boolean instructionsIncluded;

	public SetItemListing(double startingPrice,String notes, Item item,
			UserAccount seller, Condition condition, ItemListingStatus status, LocalDateTime closeTime,boolean instructionsIncluded) {
		super(startingPrice,notes,item,seller,condition,status,closeTime);
		this.instructionsIncluded = instructionsIncluded;
	}

	public boolean isInstructionsIncluded() {
		return instructionsIncluded;
	}

	public void setInstructionsIncluded(boolean instructionsIncluded) {
		this.instructionsIncluded = instructionsIncluded;
	}
	
	public static ArrayList<SetItemListing> getSetItemListings(){
		ArrayList<SetItemListing> listings = new ArrayList<SetItemListing>();
		listings.add(new SetItemListing(60.00,"Never been opened and Complete with minifigs and instructions.",new SetItem("X-Wing Fighter",767.0,414,"Cockpit opens, 1 rebel fighter minifigure",SetItemMinifigCategory.STAR_WARS,LocalDate.of(2006,2,19)),new UserAccount("jrinella","password1","James","Rinella","ultimatemanlet66207@protonmail.com",LocalDate.of(1989,1,10),Gender.MALE),Condition.NEW,ItemListingStatus.OPEN,LocalDateTime.now().plusDays(2).plusHours(12),true));
		listings.add(new SetItemListing(299.00,"Set is complete and in good condition.  Minifigure has slight wear. No instructions",new SetItem("Blacksmith Shop",825.1,616,"Structure opens to reveal interior",SetItemMinifigCategory.CASTLE,LocalDate.of(2002,6,30)),new UserAccount("mswan","password1","Meg","Swan",null,LocalDate.of(1970,10,11),Gender.FEMALE),Condition.USED,ItemListingStatus.PENDING,LocalDateTime.now().plusDays(1).plusHours(4),false));
		return listings;
	}

	@Override
	public String toString() {
		String instructionsIncludedStr = this.instructionsIncluded ? "Yes" : "No";
		return super.toString() + "Instructions included?: " + instructionsIncludedStr;
	}

	@Override
	public boolean listItem() {
		return this.instructionsIncluded && this.getCondition() == Condition.NEW;
	}

	/*@Override
	public double computeListingPrice(Listable low, Listable high) {
		// TODO Auto-generated method stub
		return 0;
	}*/
}
