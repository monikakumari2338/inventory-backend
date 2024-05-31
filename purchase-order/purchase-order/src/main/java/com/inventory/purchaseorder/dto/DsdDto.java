package com.inventory.purchaseorder.dto;

import java.time.LocalDate;

public class DsdDto {

	private String status;
	private int supplierId;
	private int cost;
	private int totalSKU;
	private String storeLocation;
	private LocalDate creationDate;
	private String attachedImage;
	private int invoiceNumber;

	public DsdDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getTotalSKU() {
		return totalSKU;
	}

	public void setTotalSKU(int totalSKU) {
		this.totalSKU = totalSKU;
	}

	public String getStoreLocation() {
		return storeLocation;
	}

	public void setStoreLocation(String storeLocation) {
		this.storeLocation = storeLocation;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public String getAttachedImage() {
		return attachedImage;
	}

	public void setAttachedImage(String attachedImage) {
		this.attachedImage = attachedImage;
	}

	public int getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(int invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public DsdDto(String status, int supplierId, int cost, int totalSKU, String storeLocation, LocalDate creationDate,
			String attachedImage, int invoiceNumber) {
		super();
		this.status = status;
		this.supplierId = supplierId;
		this.cost = cost;
		this.totalSKU = totalSKU;
		this.storeLocation = storeLocation;
		this.creationDate = creationDate;
		this.attachedImage = attachedImage;
		this.invoiceNumber = invoiceNumber;
	}

}
