package com.inventory.tsf.jpa.dto;

public class TsfDetailsUpdationDto {

	private int qty;
	// private String itemNumber;
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

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public TsfDetailsUpdationDto(int qty, String sku) {
		super();
		this.qty = qty;
		this.sku = sku;
	}

}
