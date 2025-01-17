package com.inventory.tsf.jpa.dto;

import java.time.LocalDate;

public class TSFLandingDto {

	private String id;
	private LocalDate date;
	private String status;
	private int units;
	private String storeId;
	private String type;

	public TSFLandingDto() {
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

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public TSFLandingDto(String id, LocalDate date, String status, int units, String storeId, String type) {
		super();
		this.id = id;
		this.date = date;
		this.status = status;
		this.units = units;
		this.storeId = storeId;
		this.type = type;
	}

}
