package com.inventory.po.jpa.dto;

import java.time.LocalDate;

public class ASNOnLoadDto {

	private LocalDate creationDate;
	private LocalDate receivingDate;
	private String status;
	private String asnNumber;
	private String poNumber;
	private String supplier;
	private int TotalSku;
	private int totalQty;
	private int totalReceivedQty;

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

	public String getPoNumber() {
		return poNumber;
	}

	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}

	public int getTotalReceivedQty() {
		return totalReceivedQty;
	}

	public void setTotalReceivedQty(int totalReceivedQty) {
		this.totalReceivedQty = totalReceivedQty;
	}

	public ASNOnLoadDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ASNOnLoadDto(LocalDate creationDate, LocalDate receivingDate, String status, String asnNumber,
			String poNumber, String supplier, int totalSku, int totalQty, int totalReceivedQty) {
		super();
		this.creationDate = creationDate;
		this.receivingDate = receivingDate;
		this.status = status;
		this.asnNumber = asnNumber;
		this.poNumber = poNumber;
		this.supplier = supplier;
		TotalSku = totalSku;
		this.totalQty = totalQty;
		this.totalReceivedQty = totalReceivedQty;
	}

}
