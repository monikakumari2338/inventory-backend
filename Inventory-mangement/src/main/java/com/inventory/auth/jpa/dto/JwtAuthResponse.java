package com.inventory.auth.jpa.dto;

public class JwtAuthResponse {

	private String accessToken;
	private String tokenType = "Bearer";
	private String user;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public JwtAuthResponse(String accessToken, String tokenType, String user) {
		super();
		this.accessToken = accessToken;
		this.tokenType = tokenType;
		this.user = user;
	}

	public JwtAuthResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

}
