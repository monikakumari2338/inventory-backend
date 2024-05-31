package com.inventory.purchaseorder.dto;

public class TransferReceiveProductsdto {

	private String itemNumber;
	private String itemName;
	private int expectedQty;
	private String category;
	private String color;
	private String price;
	private String size;
	private String imageData;
	private String store;
	private int stock;
	private int transferId;

	public TransferReceiveProductsdto() {
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

	public int getExpectedQty() {
		return expectedQty;
	}

	public void setExpectedQty(int expectedQty) {
		this.expectedQty = expectedQty;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getTransferId() {
		return transferId;
	}

	public void setTransferId(int transferId) {
		this.transferId = transferId;
	}

	public TransferReceiveProductsdto(String itemNumber, String itemName, int expectedQty, String category,
			String color, String price, String size, String imageData, String store, int stock, int transferId) {
		super();
		this.itemNumber = itemNumber;
		this.itemName = itemName;
		this.expectedQty = expectedQty;
		this.category = category;
		this.color = color;
		this.price = price;
		this.size = size;
		this.imageData = imageData;
		this.store = store;
		this.stock = stock;
		this.transferId = transferId;
	}

	@Override
	public String toString() {
		return "TransferReceiveProductsdto [itemNumber=" + itemNumber + ", itemName=" + itemName + ", expectedQty="
				+ expectedQty + ", category=" + category + ", color=" + color + ", price=" + price + ", size=" + size
				+ ", imageData=" + imageData + ", store=" + store + ", stock=" + stock + ", transferId=" + transferId
				+ "]";
	}

}
