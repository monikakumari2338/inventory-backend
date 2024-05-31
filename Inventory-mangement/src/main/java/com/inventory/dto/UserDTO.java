package com.inventory.dto;

public class UserDTO {

	private String email;
	private String password;
	private String storeName;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public UserDTO(String email, String password, String storeName) {
		super();
		this.email = email;
		this.password = password;
		this.storeName = storeName;
	}

	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
