package com.inventory.sc.jpa.dto;

import java.time.LocalDate;
import java.util.List;

public class StockCountCombinedDto {

	private String id;
	private LocalDate startDate;
	private LocalDate endDate;
	private LocalDate creationDate;
	private String category;
	private int totalSku;
	private String reason;
	private String status;
	private String recountStatus;
	private int totalVariance;
	private String type;
	private String subType;
	private List<ScGetProductsdto> items;

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

	public List<ScGetProductsdto> getItems() {
		return items;
	}

	public void setItems(List<ScGetProductsdto> items) {
		this.items = items;
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

	public int getTotalVariance() {
		return totalVariance;
	}

	public void setTotalVariance(int totalVariance) {
		this.totalVariance = totalVariance;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	public StockCountCombinedDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StockCountCombinedDto(String id, LocalDate startDate, LocalDate endDate, LocalDate creationDate,
			String category, int totalSku, String reason, String status, String recountStatus, int totalVariance,
			String type, String subType, List<ScGetProductsdto> items) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.creationDate = creationDate;
		this.category = category;
		this.totalSku = totalSku;
		this.reason = reason;
		this.status = status;
		this.recountStatus = recountStatus;
		this.totalVariance = totalVariance;
		this.type = type;
		this.subType = subType;
		this.items = items;
	}

	public StockCountCombinedDto(String id, LocalDate startDate, LocalDate endDate, LocalDate creationDate,
			String category, int totalSku, String reason, String status, String recountStatus, int totalVariance,
			List<ScGetProductsdto> items) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.creationDate = creationDate;
		this.category = category;
		this.totalSku = totalSku;
		this.reason = reason;
		this.status = status;
		this.recountStatus = recountStatus;
		this.totalVariance = totalVariance;
		this.items = items;
	}

}
