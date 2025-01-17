package com.inventory.email.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class UserIdData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	@Size(min = 1, max = 30)
	@NotBlank
	private String email;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserIdData(int userId, String email) {
		super();
		this.userId = userId;
		this.email = email;
	}

	public UserIdData() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "UserIdData [userId=" + userId + ", email=" + email + "]";
	}

}
