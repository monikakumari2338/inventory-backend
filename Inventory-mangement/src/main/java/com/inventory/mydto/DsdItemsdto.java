package com.inventory.mydto;

public class DsdItemsdto {
	private String itemNumber;
	private String itemName;
	private int expectedQty;
	private int qty;
	private String category;
	private String color;
	private String size;
	private String imageData;
	private String image;
	private String upc;
	private String sku;
	private String type;

	public DsdItemsdto() {
		super();
		// TODO Auto-generated constructor stub
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

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
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

	public String getUpc() {
		return upc;
	}

	public void setUpc(String upc) {
		this.upc = upc;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(String itemNumber) {
		this.itemNumber = itemNumber;
	}

	public int getExpectedQty() {
		return expectedQty;
	}

	public void setExpectedQty(int expectedQty) {
		this.expectedQty = expectedQty;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public DsdItemsdto(String itemNumber, String itemName, int expectedQty, int qty, String category, String color,
			String size, String imageData, String image, String upc, String sku, String type) {
		super();
		this.itemNumber = itemNumber;
		this.itemName = itemName;
		this.expectedQty = expectedQty;
		this.qty = qty;
		this.category = category;
		this.color = color;
		this.size = size;
		this.imageData = imageData;
		this.image = image;
		this.upc = upc;
		this.sku = sku;
		this.type = type;
	}

}
