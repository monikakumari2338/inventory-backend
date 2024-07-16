package com.inventory.mydto;

import java.time.LocalDate;

public class DsdDto {

	private String id;
	private LocalDate date;
	private String store;
	private String user;
	private String status;
	private String type;

	public DsdDto() {
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

	public DsdDto(String id, LocalDate date, String store, String user, String status, String type) {
		super();
		this.id = id;
		this.date = date;
		this.store = store;
		this.user = user;
		this.status = status;
		this.type = type;
	}

}
