package com.inventory.sc.jpa.dto;

import java.time.LocalDate;

public class SCLandingDto {

	private String id;
	private LocalDate startDate;
	private LocalDate endDate;
	private LocalDate creationDate;
	private String status;
	private String recountStatus;
	private int varianceQty;
	private int totalSku;
	private String reason;
	private String type;
	private String subType;

	public SCLandingDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public int getTotalSku() {
		return totalSku;
	}

	public void setTotalSku(int totalSku) {
		this.totalSku = totalSku;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public String getRecountStatus() {
		return recountStatus;
	}

	public void setRecountStatus(String recountStatus) {
		this.recountStatus = recountStatus;
	}

	public int getVarianceQty() {
		return varianceQty;
	}

	public void setVarianceQty(int varianceQty) {
		this.varianceQty = varianceQty;
	}

	public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	public SCLandingDto(String id, LocalDate startDate, LocalDate endDate, LocalDate creationDate, String status,
			String recountStatus, int varianceQty, int totalSku, String reason, String type, String subType) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.creationDate = creationDate;
		this.status = status;
		this.recountStatus = recountStatus;
		this.varianceQty = varianceQty;
		this.totalSku = totalSku;
		this.reason = reason;
		this.type = type;
		this.subType = subType;
	}

}
