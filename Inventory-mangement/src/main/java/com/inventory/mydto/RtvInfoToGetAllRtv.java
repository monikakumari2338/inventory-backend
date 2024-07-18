package com.inventory.mydto;

import java.time.LocalDate;

public class RtvInfoToGetAllRtv {

	private String id;
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

	public RtvInfoToGetAllRtv() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RtvInfoToGetAllRtv(String id, String status, LocalDate date, String type, int units) {
		super();
		this.id = id;
		this.status = status;
		this.date = date;
		this.type = type;
		this.units = units;
	}

}