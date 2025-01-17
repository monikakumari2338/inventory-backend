package com.inventory.rtv.jpa.dto;

public class RtvProductsdto {

	private String sku;
	private String upc;
	private int qty;
	private String image;
	private String type;

	public RtvProductsdto() {
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public RtvProductsdto(String sku, String upc, int qty, String image, String type) {
		super();
		this.sku = sku;
		this.upc = upc;
		this.qty = qty;
		this.image = image;
		this.type = type;
	}

}
