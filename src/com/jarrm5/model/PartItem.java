package com.jarrm5.model;

import java.util.ArrayList;
import java.util.function.Predicate;

import com.jarrm5.constant.PartItemCategory;
import com.jarrm5.interfaces.Listable;
import com.jarrm5.interfaces.Relatable;

public class PartItem extends Item implements Listable, Relatable {
	
	private int length;
	private int width;
	private int height;
	private PartItemCategory category;
	private ArrayList<SetItem> setItemAppearsIn;
	
	public PartItem(double weight, int length, int width, int height, PartItemCategory category, ArrayList<SetItem> setItemAppearsIn) {
		super(category + " " + length + " x " + width + " x " + height + " ",weight);
		this.length = length;
		this.width = width;
		this.height = height;
		this.category = category;
		this.setItemAppearsIn = setItemAppearsIn;
	}
	
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public ArrayList<SetItem> getSetItemAppearsIn() {
		return setItemAppearsIn;
	}

	public void setSetItemAppearsIn(ArrayList<SetItem> setItemAppearsIn) {
		this.setItemAppearsIn = setItemAppearsIn;
	}
	
	public static ArrayList<PartItem> getPartItems(){
		ArrayList<PartItem> partItems = new ArrayList<PartItem>();
		partItems.add(new PartItem(1.25,2,2,1,PartItemCategory.BRICK,null));
		partItems.add(new PartItem(1.25,1,8,-1,PartItemCategory.PLATE,null));
		partItems.add(new PartItem(2.10,2,2,2,PartItemCategory.SLOPE,null));
		partItems.add(new PartItem(2.10,3,1,-1,PartItemCategory.SLOPE,null));
		return partItems;
	}

	@Override
	public String toString() {
		String output = this.getItemName();
		if(this.setItemAppearsIn != null && !this.setItemAppearsIn.isEmpty()) {
			output += "\nAppears in Sets: \n";
			for (SetItem setItem : setItemAppearsIn) {
				output += (setItem.getItemName() + "\n");
			}
		}
		return output;
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
