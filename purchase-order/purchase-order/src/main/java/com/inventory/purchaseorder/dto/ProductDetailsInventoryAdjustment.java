package com.inventory.purchaseorder.dto;

public class ProductDetailsInventoryAdjustment {

	private String color;
	private String price;
	private String size;
	private int stock;
	private String imageData;
	private String store;
	private String itemNumber;
	private int qty;

	public ProductDetailsInventoryAdjustment(String color, String price, String size, int stock, String imageData,
			String store, String itemNumber, String poNumber, String status, int qty) {
		super();
		this.color = color;
		this.price = price;
		this.size = size;
		this.stock = stock;
		this.imageData = imageData;
		this.store = store;
		this.itemNumber = itemNumber;
		this.qty = qty;
	}

	public ProductDetailsInventoryAdjustment() {
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

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getImageData() {
		return imageData;
	}

	public void setImageData(String imageData) {
		this.imageData = imageData;
	}

	public String getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(String itemNumber) {
		this.itemNumber = itemNumber;
	}

	public int getqty() {
		return qty;
	}

	public void setqty(int qty) {
		this.qty = qty;
	}

	public ProductDetailsInventoryAdjustment(String color, String price, String size, int stock, String imageData,
			String store, String itemNumber) {
		super();
		this.color = color;
		this.price = price;
		this.size = size;
		this.stock = stock;
		this.imageData = imageData;
		this.store = store;
		this.itemNumber = itemNumber;
	}

}
