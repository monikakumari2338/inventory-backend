package com.inventory.dsd.jpa.dto;

import java.time.LocalDate;

public class DSDLandingDto {

	private String id;
	private LocalDate date;
	private String status;
	private int totalSku;
	private String supplierId;
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

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public DSDLandingDto(String id, LocalDate date, String status, int totalSku, String supplierId, String type) {
		super();
		this.id = id;
		this.date = date;
		this.status = status;
		this.totalSku = totalSku;
		this.supplierId = supplierId;
		this.type = type;
	}

}
