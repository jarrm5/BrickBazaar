package com.jarrm5.interfaces;

import java.util.function.Predicate;

public interface Listable {
	<Item> void listItem(Predicate<Item> test);
}
