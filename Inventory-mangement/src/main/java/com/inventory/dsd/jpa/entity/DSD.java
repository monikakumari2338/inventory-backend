package com.inventory.dsd.jpa.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class DSD {

	@Id
	@Size(min = 1, max = 20)
	@NotBlank
	private String dsdNumber;
	@Size(min = 1, max = 10)
	@NotBlank
	private String status;
	@Size(min = 1, max = 10)
	@NotBlank
	private String supplierId;
	@Size(min = 1, max = 30)
	@NotBlank
	private String supplierName;
	// private int cost;
	private int totalSKU;
	@Size(min = 1, max = 30)
	@NotBlank
	private String storeLocation;
	private LocalDate creationDate;
	private String attachedImage;
	private int invoiceNumber;
	@Size(min = 1, max = 20)
	@NotBlank
	private String poNumber;
	@Size(min = 1, max = 30)
	@NotBlank
	private String user;

	@OneToMany(mappedBy = "dsd", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<DsdItems> dsdItem;

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

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public List<DsdItems> getDsdItem() {
		return dsdItem;
	}

	public void setDsdItem(List<DsdItems> dsdItem) {
		this.dsdItem = dsdItem;
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

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public DSD(String dsdNumber, String status, String supplierId, String supplierName, int totalSKU,
			String storeLocation, LocalDate creationDate, String attachedImage, int invoiceNumber, String poNumber,
			String user, List<DsdItems> dsdItem) {
		super();
		this.dsdNumber = dsdNumber;
		this.status = status;
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.totalSKU = totalSKU;
		this.storeLocation = storeLocation;
		this.creationDate = creationDate;
		this.attachedImage = attachedImage;
		this.invoiceNumber = invoiceNumber;
		this.poNumber = poNumber;
		this.user = user;
		this.dsdItem = dsdItem;
	}

}
