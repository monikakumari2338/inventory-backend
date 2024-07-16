package com.inventory.myentity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class DSD {

	@Id
	private String dsdNumber;
	private String status;
	private String supplierName;
	// private int cost;
	private int totalSKU;
	private String storeLocation;
	private LocalDate creationDate;
	private String attachedImage;
	private int invoiceNumber;
	private String poNumber;
	private String user;

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

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
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

	public String getDsdNumber() {
		return dsdNumber;
	}

	public void setDsdNumber(String dsdNumber) {
		this.dsdNumber = dsdNumber;
	}

	public String getAttachedImage() {
		return attachedImage;
	}

	public void setAttachedImage(String attachedImage) {
		this.attachedImage = attachedImage;
	}

	public String getPoNumber() {
		return poNumber;
	}

	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}

	public int getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(int invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public DSD(String dsdNumber, String status, String supplierName, int totalSKU, String storeLocation,
			LocalDate creationDate, String attachedImage, int invoiceNumber, String poNumber, String user) {
		super();
		this.dsdNumber = dsdNumber;
		this.status = status;
		this.supplierName = supplierName;
		this.totalSKU = totalSKU;
		this.storeLocation = storeLocation;
		this.creationDate = creationDate;
		this.attachedImage = attachedImage;
		this.invoiceNumber = invoiceNumber;
		this.poNumber = poNumber;
		this.user = user;
	}

}
