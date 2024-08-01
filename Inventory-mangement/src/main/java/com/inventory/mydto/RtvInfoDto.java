package com.inventory.mydto;

import java.time.LocalDate;

public class RtvInfoDto {

	private String id;
	private LocalDate date;
	private String store;
	private String user;
	private String type;

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

	public RtvInfoDto(String id, LocalDate date, String store, String user, String type) {
		super();
		this.id = id;
		this.date = date;
		this.store = store;
		this.user = user;
		this.type = type;
	}

}