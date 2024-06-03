package com.inventory.myentity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class PurchaseOrder {

	@Id
	private String poNumber;
	private String status;
	private int supplierId;
	private int cost;
	private int totalSKU;
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

	public String getAttachedImage() {
		return attachedImage;
	}

	public void setAttachedImage(String attachedImage) {
		this.attachedImage = attachedImage;
	}

	public PurchaseOrder(String poNumber, String status, int supplierId, int cost, int totalSKU, String storeLocation,
			LocalDate creationDate, LocalDate receiveAfter, LocalDate receiveBefore, LocalDate expectedDeliveryDate,
			String attachedImage) {
		super();
		this.poNumber = poNumber;
		this.status = status;
		this.supplierId = supplierId;
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
		return "PurchaseOrder [poNumber=" + poNumber + ", status=" + status + ", supplierId=" + supplierId + ", cost="
				+ cost + ", totalSKU=" + totalSKU + ", storeLocation=" + storeLocation + ", creationDate="
				+ creationDate + ", ReceiveAfter=" + ReceiveAfter + ", ReceiveBefore=" + ReceiveBefore
				+ ", expectedDeliveryDate=" + expectedDeliveryDate;
	}

}
