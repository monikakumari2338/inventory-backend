package com.inventory.mydto;

public class ProductDetailsdto2 {

	private String itemNumber;
	private String itemName;
	private String category;
	private String color;
	private String size;
	private String price;
	private String sku;
	private String upc;
	private int sellableStock;
	private int nonSellableStock;
	private String imageData;

	public String getUpc() {
		return upc;
	}

	public void setUpc(String upc) {
		this.upc = upc;
	}

	public ProductDetailsdto2() {
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

	public String getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(String itemNumber) {
		this.itemNumber = itemNumber;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public int getSellableStock() {
		return sellableStock;
	}

	public void setSellableStock(int sellableStock) {
		this.sellableStock = sellableStock;
	}

	public int getNonSellableStock() {
		return nonSellableStock;
	}

	public void setNonSellableStock(int nonSellableStock) {
		this.nonSellableStock = nonSellableStock;
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

	public ProductDetailsdto2(String itemNumber, String itemName, String category, String color, String size,
			String price, String sku, String upc, int sellableStock, int nonSellableStock, String imageData) {
		super();
		this.itemNumber = itemNumber;
		this.itemName = itemName;
		this.category = category;
		this.color = color;
		this.size = size;
		this.price = price;
		this.sku = sku;
		this.upc = upc;
		this.sellableStock = sellableStock;
		this.nonSellableStock = nonSellableStock;
		this.imageData = imageData;
	}

}
