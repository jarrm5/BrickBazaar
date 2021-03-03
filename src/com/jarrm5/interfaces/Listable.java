package com.jarrm5.interfaces;

import java.util.function.Predicate;
import com.jarrm5.model.Item;
import com.jarrm5.model.ItemListing;

public interface Listable {
	//SetItemListing: If new, it has to have instructions included otherwise it cannot be listed.
	//PartItemListing: It has to have more than 5 quantity regardless of condition
	boolean listItem();
	
	//double computeListingPrice(Listable low, Listable high);
	
	
}
