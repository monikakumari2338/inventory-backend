package com.inventory.mydto;

import java.time.LocalDate;

public class DSDLandingDto {

	private String id;
	private LocalDate date;
	private String status;
	private int totalSku;
	private String supplierName;
	private String type;

	public DSDLandingDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getTotalSku() {
		return totalSku;
	}

	public void setTotalSku(int totalSku) {
		this.totalSku = totalSku;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public DSDLandingDto(String id, LocalDate date, String status, int totalSku, String supplierName, String type) {
		super();
		this.id = id;
		this.date = date;
		this.status = status;
		this.totalSku = totalSku;
		this.supplierName = supplierName;
		this.type = type;
	}

}
