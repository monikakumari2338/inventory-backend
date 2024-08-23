package com.inventory.myentity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class StockCountCreation {

	@Id
	private int countId;
	private LocalDate startDate;
	private LocalDate endDate;
	private String reason;
	private String status;
	private String store;
	private String category;
	private int totalBookQty;
	private int totalCountedQty;
	private int totaltotalVarianceQty;
	private int totalRecountVarianceQty;
	private String recountStatus;
	private int totalRecountQty;

	public StockCountCreation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCountId() {
		return countId;
	}

	public void setCountId(int countId) {
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

	public int getTotaltotalVarianceQty() {
		return totaltotalVarianceQty;
	}

	public void setTotaltotalVarianceQty(int totaltotalVarianceQty) {
		this.totaltotalVarianceQty = totaltotalVarianceQty;
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

	public StockCountCreation(int countId, LocalDate startDate, LocalDate endDate, String reason, String status,
			String store, String category, int totalBookQty, int totalCountedQty, int totaltotalVarianceQty,
			int totalRecountVarianceQty, String recountStatus, int totalRecountQty) {
		super();
		this.countId = countId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.reason = reason;
		this.status = status;
		this.store = store;
		this.category = category;
		this.totalBookQty = totalBookQty;
		this.totalCountedQty = totalCountedQty;
		this.totaltotalVarianceQty = totaltotalVarianceQty;
		this.totalRecountVarianceQty = totalRecountVarianceQty;
		this.recountStatus = recountStatus;
		this.totalRecountQty = totalRecountQty;
	}

}
