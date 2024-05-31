package com.inventory.purchaseorder.dto;

import java.time.LocalDate;

public class ContainersDto {

	private String conatinerNumber;
	private int expectedQuantity;
	private int receivedQuantity;
	private LocalDate receivedDate;
	private String status;
	private String user;
	private int asnNumber;

	public ContainersDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getConatinerNumber() {
		return conatinerNumber;
	}

	public void setConatinerNumber(String conatinerNumber) {
		this.conatinerNumber = conatinerNumber;
	}

	public int getExpectedQuantity() {
		return expectedQuantity;
	}

	public void setExpectedQuantity(int expectedQuantity) {
		this.expectedQuantity = expectedQuantity;
	}

	public int getReceivedQuantity() {
		return receivedQuantity;
	}

	public void setReceivedQuantity(int receivedQuantity) {
		this.receivedQuantity = receivedQuantity;
	}

	public LocalDate getReceivedDate() {
		return receivedDate;
	}

	public void setReceivedDate(LocalDate receivedDate) {
		this.receivedDate = receivedDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getAsnNumber() {
		return asnNumber;
	}

	public void setAsnNumber(int asnNumber) {
		this.asnNumber = asnNumber;
	}

	public ContainersDto(String conatinerNumber, int expectedQuantity, int receivedQuantity, LocalDate receivedDate,
			String status, String user, int asnNumber) {
		super();
		this.conatinerNumber = conatinerNumber;
		this.expectedQuantity = expectedQuantity;
		this.receivedQuantity = receivedQuantity;
		this.receivedDate = receivedDate;
		this.status = status;
		this.user = user;
		this.asnNumber = asnNumber;
	}

}
