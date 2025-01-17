package com.inventory.auth.jpa.dto;

public class RegisterDto {

	private int id;
	private String name;
	private String email;
	private String password;
	private String storeName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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

	public RegisterDto(int id, String name, String email, String password, String storeName) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.storeName = storeName;
	}

	@Override
	public String toString() {
		return "RegisterDto [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + "]";
	}

}
