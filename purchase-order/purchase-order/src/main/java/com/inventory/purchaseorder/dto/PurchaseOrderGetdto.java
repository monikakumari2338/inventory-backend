package com.inventory.purchaseorder.dto;

import java.time.LocalDate;
import java.util.List;

import com.inventory.purchaseorder.entity.ASN;

public class PurchaseOrderGetdto {

	private int poNumber;
	private String status;
	private int supplierId;
	private int cost;
	private int totalSKU;
	private String storeLocation;
	private LocalDate creationDate;
	private LocalDate ReceiveAfter;
	private LocalDate ReceiveBefore;
	private LocalDate expectedDeliveryDate;

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

	public int getPoNumber() {
		return poNumber;
	}

	public void setPoNumber(int poNumber) {
		this.poNumber = poNumber;
	}

	public PurchaseOrderGetdto(int poNumber, String status, int supplierId, int cost, int totalSKU,
			String storeLocation, LocalDate creationDate, LocalDate receiveAfter, LocalDate receiveBefore,
			LocalDate expectedDeliveryDate) {
		super();
		this.poNumber = poNumber;
		this.status = status;
		this.supplierId = supplierId;
		this.cost = cost;
		this.totalSKU = totalSKU;
		this.storeLocation = storeLocation;
		this.creationDate = creationDate;
		ReceiveAfter = receiveAfter;
		ReceiveBefore = receiveBefore;
		this.expectedDeliveryDate = expectedDeliveryDate;
	}

	public PurchaseOrderGetdto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
