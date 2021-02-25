package com.jarrm5.model;

import java.util.ArrayList;
import java.util.function.Predicate;

import com.jarrm5.constant.PartItemCategory;
import com.jarrm5.constant.PartItemColor;
import com.jarrm5.interfaces.Listable;
import com.jarrm5.interfaces.Relatable;

public class PartItem extends Item implements Listable, Relatable {
	
	public static int NUMBER_OF_PARTITEMS = 0;
	
	private int length;
	private int width;
	private int height;
	private PartItemCategory category;
	private PartItemColor color;
	
	
	public PartItem(double weight, int length, int width, int height, PartItemCategory category, PartItemColor color) {
		super(String.valueOf(++NUMBER_OF_PARTITEMS),category.toString(),weight);
		this.length = length;
		this.width = width;
		this.height = height;
		this.category = category;
		this.color = color;
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

	
	
	public static ArrayList<PartItem> getPartItems(){
		ArrayList<PartItem> partItems = new ArrayList<PartItem>();
		partItems.add(new PartItem(1.25,2,2,1,PartItemCategory.BRICK,PartItemColor.BLACK));
		partItems.add(new PartItem(1.25,1,8,-1,PartItemCategory.PLATE,PartItemColor.BLACK));
		partItems.add(new PartItem(2.10,2,2,2,PartItemCategory.SLOPE,PartItemColor.GREEN));
		partItems.add(new PartItem(2.10,3,1,-1,PartItemCategory.SLOPE,PartItemColor.RED));
		return partItems;
	}

	@Override
	public String toString() {
		return this.height <= 0 ? this.getItemName() + " " + this.length + " x " + this.width : this.getItemName() + " " + this.length + " x " + this.width + " x " + this.height;
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
