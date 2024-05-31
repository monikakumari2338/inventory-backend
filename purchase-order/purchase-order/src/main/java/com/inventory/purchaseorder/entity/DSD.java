package com.inventory.purchaseorder.entity;

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
public class DSD {

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dsd_sequence")
	@SequenceGenerator(name = "dsd_sequence", sequenceName = "dsd_sequence", initialValue = 80000)
	private int dsdNumber;
	private String status;
	private int supplierId;
	private int cost;
	private int totalSKU;
	private String storeLocation;
	private LocalDate creationDate;
	private String attachedImage;
	private int invoiceNumber;

	public DSD() {
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

	public int getDsdNumber() {
		return dsdNumber;
	}

	public void setDsdNumber(int dsdNumber) {
		this.dsdNumber = dsdNumber;
	}

	public String getAttachedImage() {
		return attachedImage;
	}

	public void setAttachedImage(String attachedImage) {
		this.attachedImage = attachedImage;
	}

	public DSD(String status, int supplierId, int cost, int totalSKU, String storeLocation, LocalDate creationDate,
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

	public int getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(int invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	@Override
	public String toString() {
		return "DSD [dsdNumber=" + dsdNumber + ", status=" + status + ", supplierId=" + supplierId + ", cost=" + cost
				+ ", totalSKU=" + totalSKU + ", storeLocation=" + storeLocation + ", creationDate=" + creationDate
				+ ", attachedImage=" + attachedImage + ", invoiceNumber=" + invoiceNumber + "]";
	}

}
