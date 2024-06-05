package com.inventory.mydto;

import java.time.LocalDate;

public class ASNDto {

//	private int quantity;
	private LocalDate creationDate;
	private String status;
	private String PoNumber;
	private String supplier;
	private int TotalSku;
	private int totalQty;
	// private String attachedImage;

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

	public String getPoNumber() {
		return PoNumber;
	}

	public void setPoNumber(String poNumber) {
		PoNumber = poNumber;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public int getTotalQty() {
		return totalQty;
	}

	public void setTotalQty(int totalQty) {
		this.totalQty = totalQty;
	}

	public ASNDto(LocalDate creationDate, String status, String poNumber, String supplier, int totalSku, int totalQty) {
		super();
		this.creationDate = creationDate;
		this.status = status;
		this.PoNumber = poNumber;
		this.supplier = supplier;
		this.TotalSku = totalSku;
		this.totalQty = totalQty;
	}

	public int getTotalSku() {
		return TotalSku;
	}

	public void setTotalSku(int totalSku) {
		TotalSku = totalSku;
	}

	public ASNDto() {
		super();
		// TODO Auto-generated constructor stub
	}
}
