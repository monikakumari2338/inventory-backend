package com.inventory.purchaseorder.dto;

public class ProductDetailsdto {

	private String color;
	private String price;
	private String size;
	private int sellableStock;
	private int nonSellableStock;
	private String imageData;
	private String store;
	private String itemNumber;
	private String upc;
	private String sku;
//	private String poNumber;
//	private String status;
//	private int received_qty;

	public String getUpc() {
		return upc;
	}

	public void setUpc(String upc) {
		this.upc = upc;
	}

	public ProductDetailsdto() {
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

	public ProductDetailsdto(String color, String price, String size, int sellableStock, int nonSellableStock,
			String imageData, String store, String itemNumber, String upc, String sku) {
		super();
		this.color = color;
		this.price = price;
		this.size = size;
		this.sellableStock = sellableStock;
		this.nonSellableStock = nonSellableStock;
		this.imageData = imageData;
		this.store = store;
		this.itemNumber = itemNumber;
		this.upc = upc;
		this.sku = sku;
	}

}
