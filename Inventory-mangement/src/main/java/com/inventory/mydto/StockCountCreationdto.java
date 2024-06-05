package com.inventory.mydto;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class StockCountCreationdto {

	private int countId;
	private String countDescription;
	// private LocalDateTime date;
	private LocalDate date;
	private String status;
	private int totalBookQty;
	private int totalItems;
	private String category;
	private String reCount;
	private String store;

	public StockCountCreationdto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCountId() {
		return countId;
	}

	public void setCountId(int countId) {
		this.countId = countId;
	}

	public String getCountDescription() {
		return countDescription;
	}

	public void setCountDescription(String countDescription) {
		this.countDescription = countDescription;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTotalBookQty() {
		return totalBookQty;
	}

	public void setTotalBookQty(int totalBookQty) {
		this.totalBookQty = totalBookQty;
	}

	public String getReCount() {
		return reCount;
	}

	public void setReCount(String reCount) {
		this.reCount = reCount;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public int getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public StockCountCreationdto(int countId, String countDescription, LocalDate date, String status, int totalBookQty,
			int totalItems, String category, String reCount, String store) {
		super();
		this.countId = countId;
		this.countDescription = countDescription;
		this.date = date;
		this.status = status;
		this.totalBookQty = totalBookQty;
		this.totalItems = totalItems;
		this.category = category;
		this.reCount = reCount;
		this.store = store;
	}

	@Override
	public String toString() {
		return "StockCountCreation [countId=" + countId + ", countDescription=" + countDescription + ", date=" + date
				+ ", status=" + status + ", totalBookQty=" + totalBookQty + "]";
	}

}
