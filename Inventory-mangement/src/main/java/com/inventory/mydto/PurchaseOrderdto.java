package com.inventory.mydto;

import java.time.LocalDate;

public class PurchaseOrderdto {

//	private int poNumber;

	private String supplierId;
	private String supplierName;
	private int totalSKU;
	private int totalItems;
	private String storeLocation;
	private LocalDate creationDate;
	private LocalDate ReceiveAfter;
	private LocalDate ReceiveBefore;
	private LocalDate expectedDeliveryDate;

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
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

	public LocalDate getReceiveAfter() {
		return ReceiveAfter;
	}

	public void setReceiveAfter(LocalDate receiveAfter) {
		ReceiveAfter = receiveAfter;
	}

	public LocalDate getReceiveBefore() {
		return ReceiveBefore;
	}

	public void setReceiveBefore(LocalDate receiveBefore) {
		ReceiveBefore = receiveBefore;
	}

	public LocalDate getExpectedDeliveryDate() {
		return expectedDeliveryDate;
	}

	public void setExpectedDeliveryDate(LocalDate expectedDeliveryDate) {
		this.expectedDeliveryDate = expectedDeliveryDate;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public int getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}

	public PurchaseOrderdto(String supplierId, String supplierName, int totalSKU, String storeLocation,
			LocalDate creationDate, LocalDate receiveAfter, LocalDate receiveBefore, LocalDate expectedDeliveryDate) {
		super();

		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.totalSKU = totalSKU;
		this.storeLocation = storeLocation;
		this.creationDate = creationDate;
		ReceiveAfter = receiveAfter;
		ReceiveBefore = receiveBefore;
		this.expectedDeliveryDate = expectedDeliveryDate;
	}

	public PurchaseOrderdto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
