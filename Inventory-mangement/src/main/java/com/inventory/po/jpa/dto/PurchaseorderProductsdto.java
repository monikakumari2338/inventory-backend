package com.inventory.po.jpa.dto;

public class PurchaseorderProductsdto {

	private String itemNumber;
	private String itemName;
	private String category;
	private String color;
	private String size;
	private String sku;
	private String upc;
	private int expectedQty;
	private int receivedQty;
	private int remainingQty;
	private String image;
	private String imageData;
	private String type;

	public PurchaseorderProductsdto() {
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getImageData() {
		return imageData;
	}

	public void setImageData(String imageData) {
		this.imageData = imageData;
	}

	public int getExpectedQty() {
		return expectedQty;
	}

	public void setExpectedQty(int expectedQty) {
		this.expectedQty = expectedQty;
	}

	public int getReceivedQty() {
		return receivedQty;
	}

	public void setReceivedQty(int receivedQty) {
		this.receivedQty = receivedQty;
	}

	public int getRemainingQty() {
		return remainingQty;
	}

	public void setRemainingQty(int remainingQty) {
		this.remainingQty = remainingQty;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public PurchaseorderProductsdto(String itemNumber, String itemName, String category, String color, String size,
			String sku, String upc, int expectedQty, int receivedQty, int remainingQty, String image,
			String imageData) {
		super();
		this.itemNumber = itemNumber;
		this.itemName = itemName;
		this.category = category;
		this.color = color;
		this.size = size;
		this.sku = sku;
		this.upc = upc;
		this.expectedQty = expectedQty;
		this.receivedQty = receivedQty;
		this.remainingQty = remainingQty;
		this.image = image;
		this.imageData = imageData;
	}

}
