package com.inventory.tsf.jpa.dto;

import java.time.LocalDate;

public class TsfHeadDtoToGetTransfers {

	private String id;
	private int storeId;
	private String storeTo;
	private String status;
	private LocalDate date;
	private String type;
	private int units;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
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

	public String getStoreTo() {
		return storeTo;
	}

	public void setStoreTo(String storeTo) {
		this.storeTo = storeTo;
	}

	public TsfHeadDtoToGetTransfers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TsfHeadDtoToGetTransfers(String id, int storeId, String storeTo, String status, LocalDate date, String type,
			int units) {
		super();
		this.id = id;
		this.storeId = storeId;
		this.storeTo = storeTo;
		this.status = status;
		this.date = date;
		this.type = type;
		this.units = units;
	}

}
