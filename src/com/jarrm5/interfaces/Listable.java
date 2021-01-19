package com.jarrm5.interfaces;

import java.util.function.Predicate;

public interface Listable {
	//SetItem: If new, it has to have instructions included otherwise it cannot be listed.
	<Item> void listItem(Predicate<Item> test);
	
	double computeListingPrice(Listable low, Listable high);
}
