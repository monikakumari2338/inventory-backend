package com.inventory.sc.jpa.dto;

public class StockCountUpdateProductsDto {

	private String sku;
	private String upc;
	private int qty;

	public StockCountUpdateProductsDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getUpc() {
		return upc;
	}

	public void setUpc(String upc) {
		this.upc = upc;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public StockCountUpdateProductsDto(String sku, String upc, int qty) {
		super();
		this.sku = sku;
		this.upc = upc;
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "StockCountUpdateProductsDto [sku=" + sku + ", upc=" + upc + ", qty=" + qty + "]";
	}

}
