package com.inventory.sc.jpa.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class StockCountCreation {

	@Id
	private String countId;
	private LocalDate startDate;
	private LocalDate endDate;
	private LocalDate creationDate;
	@Size(min = 1, max = 30)
	@NotBlank
	private String reason;
	@Size(min = 1, max = 10)
	@NotBlank
	private String status;
	@Size(min = 1, max = 30)
	@NotBlank
	private String store;
	@Size(min = 1, max = 20)
	@NotBlank
	private String category;
	private int totalBookQty;
	private int totalCountedQty;
	private int totalVarianceQty;
	private int totalRecountVarianceQty;
	private String recountStatus;
	private int totalRecountQty;
	@Size(min = 1, max = 10)
	@NotBlank
	private String type;
	@Size(min = 1, max = 10)
	@NotBlank
	private String subType;

	public StockCountCreation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCountId() {
		return countId;
	}

	public void setCountId(String countId) {
		this.countId = countId;
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

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public int getTotalBookQty() {
		return totalBookQty;
	}

	public void setTotalBookQty(int totalBookQty) {
		this.totalBookQty = totalBookQty;
	}

	public String getRecountStatus() {
		return recountStatus;
	}

	public void setRecountStatus(String recountStatus) {
		this.recountStatus = recountStatus;
	}

	public int getTotalCountedQty() {
		return totalCountedQty;
	}

	public void setTotalCountedQty(int totalCountedQty) {
		this.totalCountedQty = totalCountedQty;
	}

	public int getTotalRecountVarianceQty() {
		return totalRecountVarianceQty;
	}

	public void setTotalRecountVarianceQty(int totalRecountVarianceQty) {
		this.totalRecountVarianceQty = totalRecountVarianceQty;
	}

	public int getTotalRecountQty() {
		return totalRecountQty;
	}

	public void setTotalRecountQty(int totalRecountQty) {
		this.totalRecountQty = totalRecountQty;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getTotalVarianceQty() {
		return totalVarianceQty;
	}

	public void setTotalVarianceQty(int totalVarianceQty) {
		this.totalVarianceQty = totalVarianceQty;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
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

	public StockCountCreation(String countId, LocalDate startDate, LocalDate endDate, LocalDate creationDate,
			String reason, String status, String store, String category, int totalBookQty, int totalCountedQty,
			int totalVarianceQty, int totalRecountVarianceQty, String recountStatus, int totalRecountQty) {
		super();
		this.countId = countId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.creationDate = creationDate;
		this.reason = reason;
		this.status = status;
		this.store = store;
		this.category = category;
		this.totalBookQty = totalBookQty;
		this.totalCountedQty = totalCountedQty;
		this.totalVarianceQty = totalVarianceQty;
		this.totalRecountVarianceQty = totalRecountVarianceQty;
		this.recountStatus = recountStatus;
		this.totalRecountQty = totalRecountQty;
	}

}
