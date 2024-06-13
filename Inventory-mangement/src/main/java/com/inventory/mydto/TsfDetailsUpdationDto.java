package com.inventory.mydto;

public class TsfDetailsUpdationDto {

	private int qty;
	private String itemNumber;
	private String sku;

	public TsfDetailsUpdationDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(String itemNumber) {
		this.itemNumber = itemNumber;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public TsfDetailsUpdationDto(int qty, String itemNumber, String sku) {
		super();
		this.qty = qty;
		this.itemNumber = itemNumber;
		this.sku = sku;
	}

}
