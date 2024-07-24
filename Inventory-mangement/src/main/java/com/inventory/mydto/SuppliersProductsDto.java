package com.inventory.mydto;

public class SuppliersProductsDto {

	private String itemNumber;
	private String itemName;
	private String color;
	private String price;
	private String size;
	private String category;
	private String imageData;
	private String upc;
	private String sku;
	private String store;
	private String supplierId;

	public SuppliersProductsDto() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public SuppliersProductsDto(String itemNumber, String itemName, String color, String price, String size,
			String category, String imageData, String upc, String sku, String store, String supplierId) {
		super();
		this.itemNumber = itemNumber;
		this.itemName = itemName;
		this.color = color;
		this.price = price;
		this.size = size;
		this.category = category;
		this.imageData = imageData;
		this.upc = upc;
		this.sku = sku;
		this.store = store;
		this.supplierId = supplierId;
	}

}
