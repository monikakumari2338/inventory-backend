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
public class ASN {
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_sequence")
	@SequenceGenerator(name = "my_sequence", sequenceName = "my_sequence", initialValue = 300000)
	private int asnNumber;
//	private int quantity;
	private int totalSKU;
	private LocalDate creationDate;
	private String status;
	private String attachedImage;
	private String supplier;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name = "asn_po", joinColumns = {
			@JoinColumn(name = "asnNumber", referencedColumnName = "asnNumber") }, inverseJoinColumns = {
					@JoinColumn(name = "poNumber", referencedColumnName = "poNumber") })
	private List<PurchaseOrder> purchaseOrder;

	public int getAsnNumber() {
		return asnNumber;
	}

	public void setAsnNumber(int asnNumber) {
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

	public List<PurchaseOrder> getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(List<PurchaseOrder> purchaseOrder) {
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

	public ASN( int totalSKU, LocalDate creationDate, String status, String attachedImage, String supplier,
			List<PurchaseOrder> purchaseOrder) {
		super();
		this.totalSKU = totalSKU;
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

	@Override
	public String toString() {
		return "ASN [asnNumber=" + asnNumber + ", creationDate=" + creationDate + ", status="
				+ status + ", purchaseOrder=" + purchaseOrder + "]";
	}

}
