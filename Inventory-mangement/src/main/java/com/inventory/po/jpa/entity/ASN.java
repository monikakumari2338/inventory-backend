package com.inventory.po.jpa.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class ASN {

	@Size(min = 1, max = 20)
	@NotBlank
	@Id
	private String asnNumber;
	private int totalSKU;
	private int totalQty;
	private LocalDate creationDate;
	private LocalDate ReceivingDate;
	@Size(min = 1, max = 10)
	@NotBlank
	private String status;
	private String attachedImage;
	@Size(min = 1, max = 100)
	@NotBlank
	private String supplier;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinTable(name = "asn_po", joinColumns = {
			@JoinColumn(name = "asnNumber", referencedColumnName = "asnNumber") }, inverseJoinColumns = {
					@JoinColumn(name = "poNumber", referencedColumnName = "poNumber") })
	private PurchaseOrder purchaseOrder;

	public String getAsnNumber() {
		return asnNumber;
	}

	public void setAsnNumber(String asnNumber) {
		this.asnNumber = asnNumber;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	public String getAttachedImage() {
		return attachedImage;
	}

	public void setAttachedImage(String attachedImage) {
		this.attachedImage = attachedImage;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public int getTotalSKU() {
		return totalSKU;
	}

	public void setTotalSKU(int totalSKU) {
		this.totalSKU = totalSKU;
	}

	public int getTotalQty() {
		return totalQty;
	}

	public void setTotalQty(int totalQty) {
		this.totalQty = totalQty;
	}

	public LocalDate getReceivingDate() {
		return ReceivingDate;
	}

	public void setReceivingDate(LocalDate receivingDate) {
		ReceivingDate = receivingDate;
	}

	public ASN(String asnNumber, int totalSKU, int totalQty, LocalDate creationDate, String status,
			String attachedImage, String supplier, PurchaseOrder purchaseOrder) {
		super();
		this.asnNumber = asnNumber;
		this.totalSKU = totalSKU;
		this.totalQty = totalQty;
		this.creationDate = creationDate;
		this.status = status;
		this.attachedImage = attachedImage;
		this.supplier = supplier;
		this.purchaseOrder = purchaseOrder;
	}

	public ASN() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ASN(String asnNumber, LocalDate creationDate, String status, String supplier, PurchaseOrder purchaseOrder) {
		super();
		this.asnNumber = asnNumber;
		this.creationDate = creationDate;
		this.status = status;
		this.supplier = supplier;
		this.purchaseOrder = purchaseOrder;
	}

	@Override
	public String toString() {
		return "ASN [asnNumber=" + asnNumber + ", creationDate=" + creationDate + ", status=" + status
				+ ", purchaseOrder=" + purchaseOrder + "]";
	}

}
