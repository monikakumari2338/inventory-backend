package com.inventory.purchaseorder.dto;

public class StoresDto {

	private int storeId;
	private String storeName;
	private int storeStock;
	private String storeAddress;
	private String color;
	private String price;
	private String size;
	private String imageData;

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public int getStoreStock() {
		return storeStock;
	}

	public void setStoreStock(int storeStock) {
		this.storeStock = storeStock;
	}

	public String getStoreAddress() {
		return storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
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

	public StoresDto(int storeId, String storeName, int storeStock, String storeAddress, String color, String price,
			String size,String imageData) {
		super();
		this.storeId = storeId;
		this.storeName = storeName;
		this.storeStock = storeStock;
		this.storeAddress = storeAddress;
		this.color = color;
		this.price = price;
		this.size = size;
		this.imageData = imageData;
	}

	@Override
	public String toString() {
		return "StoresDto [storeId=" + storeId + ", storeName=" + storeName + ", storeStock=" + storeStock
				+ ", storeAddress=" + storeAddress + "]";
	}

	public StoresDto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
