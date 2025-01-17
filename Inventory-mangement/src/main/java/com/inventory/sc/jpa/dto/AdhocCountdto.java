package com.inventory.sc.jpa.dto;

import java.time.LocalDate;

public class AdhocCountdto {

	private int totalBookQty;
	private int countedQty;
	private int varianceQty;
	private int reCountQty;
	private int recountVarianceQty;
	private String reCountStatus;
	private String store;
	private String reason;
	private String category;
	private LocalDate creationDate;

	public AdhocCountdto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getTotalBookQty() {
		return totalBookQty;
	}

	public void setTotalBookQty(int totalBookQty) {
		this.totalBookQty = totalBookQty;
	}

	public int getCountedQty() {
		return countedQty;
	}

	public void setCountedQty(int countedQty) {
		this.countedQty = countedQty;
	}

	public int getVarianceQty() {
		return varianceQty;
	}

	public void setVarianceQty(int varianceQty) {
		this.varianceQty = varianceQty;
	}

	public int getReCountQty() {
		return reCountQty;
	}

	public void setReCountQty(int reCountQty) {
		this.reCountQty = reCountQty;
	}

	public int getRecountVarianceQty() {
		return recountVarianceQty;
	}

	public void setRecountVarianceQty(int recountVarianceQty) {
		this.recountVarianceQty = recountVarianceQty;
	}

	public String getReCountStatus() {
		return reCountStatus;
	}

	public void setReCountStatus(String reCountStatus) {
		this.reCountStatus = reCountStatus;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public AdhocCountdto(int totalBookQty, int countedQty, int varianceQty, int reCountQty, int recountVarianceQty,
			String reCountStatus, String store, String reason, String category, LocalDate creationDate) {
		super();
		this.totalBookQty = totalBookQty;
		this.countedQty = countedQty;
		this.varianceQty = varianceQty;
		this.reCountQty = reCountQty;
		this.recountVarianceQty = recountVarianceQty;
		this.reCountStatus = reCountStatus;
		this.store = store;
		this.reason = reason;
		this.category = category;
		this.creationDate = creationDate;
	}

}
