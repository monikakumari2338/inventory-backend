package com.inventory.mydto;

import java.time.LocalDate;

public class InventoryAdjustmentdto {

	private String adjId;
	private LocalDate date;
	private String store;
	private String user;
	private String status;
	private String type;

	public InventoryAdjustmentdto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getAdjId() {
		return adjId;
	}

	public void setAdjId(String adjId) {
		this.adjId = adjId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
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

	public InventoryAdjustmentdto(String adjId, LocalDate date, String store, String user, String status, String type) {
		super();
		this.adjId = adjId;
		this.date = date;
		this.store = store;
		this.user = user;
		this.status = status;
		this.type = type;
	}

}
