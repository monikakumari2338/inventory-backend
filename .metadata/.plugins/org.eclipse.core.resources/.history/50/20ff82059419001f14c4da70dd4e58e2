package com.inventory.purchaseorder.entity;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "rtv_info")
public class ReturnToVendorInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rtvId;
	private int poNumber;
	private int supplierId;
	private String supplierName;
	private LocalDate date;
	private String status;

	public ReturnToVendorInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getRtvId() {
		return rtvId;
	}

	public void setRtvId(int rtvId) {
		this.rtvId = rtvId;
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

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ReturnToVendorInfo(int poNumber, int supplierId, String supplierName, LocalDate date, String status) {
		super();
		this.poNumber = poNumber;
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.date = date;
		this.status = status;
	}

	@Override
	public String toString() {
		return "ReturnToVendorInfo [rtvId=" + rtvId + ", poNumber=" + poNumber + ", supplierId=" + supplierId
				+ ", supplierName=" + supplierName + ", date=" + date + "]";
	}

}
