package com.inventory.purchaseorder.dto;

public class PurchaseOrderItemsGetDto3 {
	private String itemNumber;
	private String itemName;
	private int expectedQty;
	private int receivedQty;
	private int remainingQty;
	private int damageQty;
	private String damageImage;
	private String sku;
	private int poNumber;

	public PurchaseOrderItemsGetDto3() {
		super();
		// TODO Auto-generated constructor stub
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

	public int getPoNumber() {
		return poNumber;
	}

	public void setPoNumber(int poNumber) {
		this.poNumber = poNumber;
	}

	public int getDamageQty() {
		return damageQty;
	}

	public void setDamageQty(int damageQty) {
		this.damageQty = damageQty;
	}

	public String getDamageImage() {
		return damageImage;
	}

	public void setDamageImage(String damageImage) {
		this.damageImage = damageImage;
	}

	public PurchaseOrderItemsGetDto3(String itemNumber, String itemName, int expectedQty, int receivedQty,
			int remainingQty, int damageQty, String damageImage, String sku, int poNumber) {
		super();
		this.itemNumber = itemNumber;
		this.itemName = itemName;
		this.expectedQty = expectedQty;
		this.receivedQty = receivedQty;
		this.remainingQty = remainingQty;
		this.damageQty = damageQty;
		this.damageImage = damageImage;
		this.sku = sku;
		this.poNumber = poNumber;
	}

}
