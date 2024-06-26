package com.inventory.mydto;

public class IAExcelUploadProductsdto {

	private String itemNumber;
	private String itemName;
	private String category;
	private String sku;
	private String upc;
	private String color;
	private String price;
	private String size;
	private String image;
	private int sellableQty;
	private int nonSellableQty;
	private int adjQty;

	public IAExcelUploadProductsdto() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getSellableQty() {
		return sellableQty;
	}

	public void setSellableQty(int sellableQty) {
		this.sellableQty = sellableQty;
	}

	public int getNonSellableQty() {
		return nonSellableQty;
	}

	public void setNonSellableQty(int nonSellableQty) {
		this.nonSellableQty = nonSellableQty;
	}

	public int getAdjQty() {
		return adjQty;
	}

	public void setAdjQty(int adjQty) {
		this.adjQty = adjQty;
	}

	public IAExcelUploadProductsdto(String itemNumber, String itemName, String category, String sku, String upc,
			String color, String price, String size, String image, int sellableQty, int nonSellableQty, int adjQty) {
		super();
		this.itemNumber = itemNumber;
		this.itemName = itemName;
		this.category = category;
		this.sku = sku;
		this.upc = upc;
		this.color = color;
		this.price = price;
		this.size = size;
		this.image = image;
		this.sellableQty = sellableQty;
		this.nonSellableQty = nonSellableQty;
		this.adjQty = adjQty;
	}

}
