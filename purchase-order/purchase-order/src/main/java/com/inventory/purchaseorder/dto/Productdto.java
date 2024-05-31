package com.inventory.purchaseorder.dto;

public class Productdto {

	private String itemNumber;
	private String itemName;
	//private int categoryID;
	private String categoryName;

	public Productdto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Productdto(String itemNumber, String itemName,String categoryName) {
		super();
		this.itemNumber = itemNumber;
		this.itemName = itemName;
		//this.categoryID = categoryID;
		this.categoryName = categoryName;
	}

	public String getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(String itemNumber) {
		this.itemNumber = itemNumber;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	

}
