package com.inventory.mydto;

public class StockCountCreationProductsDto {

	private String sku;
	private String upc;

	public StockCountCreationProductsDto() {
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

	public StockCountCreationProductsDto(String sku, String upc) {
		super();
		this.sku = sku;
		this.upc = upc;
	}

}
