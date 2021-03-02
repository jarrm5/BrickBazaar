package com.jarrm5.interfaces;

import java.util.function.Predicate;
import com.jarrm5.model.Item;

public interface Listable {
	//SetItem: If new, it has to have instructions included otherwise it cannot be listed.
	boolean listItem(Predicate<Item> tester);
	
	double computeListingPrice(Listable low, Listable high);
	
	
}
