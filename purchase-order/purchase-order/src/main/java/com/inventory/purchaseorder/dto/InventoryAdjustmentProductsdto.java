package com.inventory.purchaseorder.dto;

public class InventoryAdjustmentProductsdto {

	private String itemNumber;
	private String itemName;
	private String category;
	private String sku;
	private String upc;
	private String store;
	private String reason;
	private String status;
	private String user;
	private int adjQty;
	private String image;

	public InventoryAdjustmentProductsdto() {
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

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getAdjQty() {
		return adjQty;
	}

	public void setAdjQty(int adjQty) {
		this.adjQty = adjQty;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public InventoryAdjustmentProductsdto(String itemNumber, String itemName, String category, String sku, String upc,
			String store, String reason, String status, String user, int adjQty, String image) {
		super();
		this.itemNumber = itemNumber;
		this.itemName = itemName;
		this.category = category;
		this.sku = sku;
		this.upc = upc;
		this.store = store;
		this.reason = reason;
		this.status = status;
		this.user = user;
		this.adjQty = adjQty;
		this.image = image;

	}

}
