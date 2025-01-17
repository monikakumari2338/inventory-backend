package com.inventory.rtv.jpa.dto;

import java.time.LocalDate;

public class RtvInfoDto {

	private String id;
	private LocalDate date;
	private String store;
	private String user;
	private String type;
	private String status;

	public RtvInfoDto() {
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public RtvInfoDto(String id, LocalDate date, String store, String user, String type, String status) {
		super();
		this.id = id;
		this.date = date;
		this.store = store;
		this.user = user;
		this.type = type;
		this.status = status;
	}

}
