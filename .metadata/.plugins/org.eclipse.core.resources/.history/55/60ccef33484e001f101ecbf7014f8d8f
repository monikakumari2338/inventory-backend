package com.inventory.myentity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class PurchaseOrder {

	@Id
	private String poNumber;
	private String status;
	private String supplierId;
	private String supplierName;
	private int cost;
	private int totalSKU;
	private int totalItems;
	private String storeLocation;
	private LocalDate creationDate;
	private LocalDate ReceiveAfter;
	private LocalDate ReceiveBefore;
	private LocalDate expectedDeliveryDate;
	private String attachedImage;

	public PurchaseOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getPoNumber() {
		return poNumber;
	}

	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
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

	public String getAttachedImage() {
		return attachedImage;
	}

	public void setAttachedImage(String attachedImage) {
		this.attachedImage = attachedImage;
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

	public PurchaseOrder(String poNumber, String status, String supplierId, String supplierName, int cost, int totalSKU,
			String storeLocation, LocalDate creationDate, LocalDate receiveAfter, LocalDate receiveBefore,
			LocalDate expectedDeliveryDate, String attachedImage) {
		super();
		this.poNumber = poNumber;
		this.status = status;
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.cost = cost;
		this.totalSKU = totalSKU;
		this.storeLocation = storeLocation;
		this.creationDate = creationDate;
		this.ReceiveAfter = receiveAfter;
		this.ReceiveBefore = receiveBefore;
		this.expectedDeliveryDate = expectedDeliveryDate;
		this.attachedImage = attachedImage;
	}

	@Override
	public String toString() {
		return "PurchaseOrder [poNumber=" + poNumber + ", status=" + status + ", supplierId=" + supplierId
				+ ", supplierName=" + supplierName + ", cost=" + cost + ", totalSKU=" + totalSKU + ", totalItems="
				+ totalItems + ", storeLocation=" + storeLocation + ", creationDate=" + creationDate + ", ReceiveAfter="
				+ ReceiveAfter + ", ReceiveBefore=" + ReceiveBefore + ", expectedDeliveryDate=" + expectedDeliveryDate
				+ ", attachedImage=" + attachedImage + "]";
	}

}
