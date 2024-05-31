package com.inventory.purchaseorder.dto;

import java.time.LocalDate;
import java.util.List;

import com.inventory.purchaseorder.entity.PurchaseOrder;

public class ASNOnLoadDto {

	private int asnNumber;
	private int totalSKU;
	private LocalDate creationDate;
	private String status;
	private String supplier;

	public int getTotalSKU() {
		return totalSKU;
	}

	public void setTotalSKU(int totalSKU) {
		this.totalSKU = totalSKU;
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

	public int getAsnNumber() {
		return asnNumber;
	}

	public void setAsnNumber(int asnNumber) {
		this.asnNumber = asnNumber;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public ASNOnLoadDto(int asnNumber, int totalSKU, LocalDate creationDate, String status, String supplier) {
		super();
		this.asnNumber = asnNumber;
		this.totalSKU = totalSKU;
		this.creationDate = creationDate;
		this.status = status;
		this.supplier = supplier;
	}

	public ASNOnLoadDto() {
		super();
		// TODO Auto-generated constructor stub
	}
}
