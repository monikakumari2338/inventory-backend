package com.inventory.tsf.jpa.dto;

import java.time.LocalDate;

public class TsfDto {

	private String id;
	private LocalDate date;
	private String store;
	private String storeTo;
	private String user;
	private String status;
	private int totalSku;
	private String type;

	public TsfDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getStoreTo() {
		return storeTo;
	}

	public void setStoreTo(String storeTo) {
		this.storeTo = storeTo;
	}

	public TsfDto(String id, LocalDate date, String store, String storeTo, String user, String status, int totalSku,
			String type) {
		super();
		this.id = id;
		this.date = date;
		this.store = store;
		this.storeTo = storeTo;
		this.user = user;
		this.status = status;
		this.totalSku = totalSku;
		this.type = type;
	}

}
