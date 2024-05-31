package com.inventory.purchaseorder.dto;

import java.time.LocalDate;

public class ASNPOItemDetailsDto {

	private String itemNumber;
	private String itemName;
	private int expectedQty;
	private int shippedQty;
	private int remainingQty;
	private String category;
	private String color;
	private String price;
	private String size;
	private String imageData;
	private String upc;
	private String sku;
	private String taxPercentage;
	private String taxCode;
	private LocalDate ReceivedDate;
	private int poNumber;

	// private int asnNumber;

	public ASNPOItemDetailsDto() {
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

	public int getShippedQty() {
		return shippedQty;
	}

	public void setShippedQty(int shippedQty) {
		this.shippedQty = shippedQty;
	}

	public int getPoNumber() {
		return poNumber;
	}

	public void setPoNumber(int poNumber) {
		this.poNumber = poNumber;
	}

	public int getRemainingQty() {
		return remainingQty;
	}

	public void setRemainingQty(int remainingQty) {
		this.remainingQty = remainingQty;
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

	public String getTaxPercentage() {
		return taxPercentage;
	}

	public void setTaxPercentage(String taxPercentage) {
		this.taxPercentage = taxPercentage;
	}

	public String getTaxCode() {
		return taxCode;
	}

	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

	public LocalDate getReceivedDate() {
		return ReceivedDate;
	}

	public void setReceivedDate(LocalDate receivedDate) {
		ReceivedDate = receivedDate;
	}

	public ASNPOItemDetailsDto(String itemNumber, String itemName, int expectedQty, int shippedQty, int remainingQty,
			String category, String color, String price, String size, String imageData, String upc, String sku,
			String taxPercentage, String taxCode, LocalDate receivedDate, int poNumber) {
		super();
		this.itemNumber = itemNumber;
		this.itemName = itemName;
		this.expectedQty = expectedQty;
		this.shippedQty = shippedQty;
		this.remainingQty = remainingQty;
		this.category = category;
		this.color = color;
		this.price = price;
		this.size = size;
		this.imageData = imageData;
		this.upc = upc;
		this.sku = sku;
		this.taxPercentage = taxPercentage;
		this.taxCode = taxCode;
		this.ReceivedDate = receivedDate;
		this.poNumber = poNumber;
	}

}