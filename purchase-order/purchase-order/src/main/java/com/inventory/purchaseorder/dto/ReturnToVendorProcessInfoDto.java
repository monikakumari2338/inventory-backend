package com.inventory.purchaseorder.dto;

import java.time.LocalDate;
import java.util.Date;

public class ReturnToVendorProcessInfoDto {

	private int poNumber;
	private int supplierId;
	private String supplierName;
	private String status;
	private String reason;
	private LocalDate date;

	public ReturnToVendorProcessInfoDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPoNumber() {
		return poNumber;
	}

	public void setPoNumber(int poNumber) {
		this.poNumber = poNumber;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public ReturnToVendorProcessInfoDto(int poNumber, int supplierId, String supplierName, String status, String reason,
			LocalDate date) {
		super();

		this.poNumber = poNumber;
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.status = status;
		this.reason = reason;
		this.date = date;
	}

	@Override
	public String toString() {
		return "ReturnToVendorProcessInfoDto [poNumber=" + poNumber + ", supplierId=" + supplierId + ", supplierName="
				+ supplierName + ", status=" + status + ", reason=" + reason + ", date=" + date + "]";
	}

}
