package com.inventory.mydto;

import java.time.LocalDate;

public class ASNOnLoadDto {

	private LocalDate creationDate;
	private LocalDate receivingDate;
	private String status;
	private String asnNumber;
	private String supplier;
	private int TotalSku;
	private int totalQty;

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public LocalDate getReceivingDate() {
		return receivingDate;
	}

	public void setReceivingDate(LocalDate receivingDate) {
		this.receivingDate = receivingDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAsnNumber() {
		return asnNumber;
	}

	public void setAsnNumber(String asnNumber) {
		this.asnNumber = asnNumber;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public int getTotalSku() {
		return TotalSku;
	}

	public void setTotalSku(int totalSku) {
		TotalSku = totalSku;
	}

	public int getTotalQty() {
		return totalQty;
	}

	public void setTotalQty(int totalQty) {
		this.totalQty = totalQty;
	}

	public ASNOnLoadDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ASNOnLoadDto(LocalDate creationDate, LocalDate receivingDate, String status, String asnNumber,
			String supplier, int totalSku, int totalQty) {
		super();
		this.creationDate = creationDate;
		this.receivingDate = receivingDate;
		this.status = status;
		this.asnNumber = asnNumber;
		this.supplier = supplier;
		TotalSku = totalSku;
		this.totalQty = totalQty;
	}

}
