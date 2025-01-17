package com.inventory.sc.jpa.dto;

public class ScGetProductsdto {

	private String itemNumber;
	private String itemName;
	private String category;
	private String color;
	private String size;
	private String sku;
	private String upc;
	private int qty;
	private int variance;
	private String image;
	private String imageData;
	// private String type;

	public ScGetProductsdto() {
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

	public int getVariance() {
		return variance;
	}

	public void setVariance(int variance) {
		this.variance = variance;
	}

	public ScGetProductsdto(String itemNumber, String itemName, String category, String color, String size, String sku,
			String upc, int qty, int variance, String image, String imageData) {
		super();
		this.itemNumber = itemNumber;
		this.itemName = itemName;
		this.category = category;
		this.color = color;
		this.size = size;
		this.sku = sku;
		this.upc = upc;
		this.qty = qty;
		this.variance = variance;
		this.image = image;
		this.imageData = imageData;

	}

	@Override
	public String toString() {
		return "InventoryAdjustmentProductsdto [itemNumber=" + itemNumber + ", itemName=" + itemName + ", category="
				+ category + ", color=" + color + ", size=" + size + ", sku=" + sku + ", upc=" + upc + ", qty=" + qty
				+ ", image=" + image + ", imageData=" + imageData + "]";
	}

}
