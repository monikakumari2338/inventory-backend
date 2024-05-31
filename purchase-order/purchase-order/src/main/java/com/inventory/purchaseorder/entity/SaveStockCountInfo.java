package com.inventory.purchaseorder.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class SaveStockCountInfo {

	@Id
	private int countId;
	private String countDescription;
	@JsonFormat(pattern = "dd-mm-yyyy HH:mm:ss")
	private String startedAt;
	@JsonFormat(pattern = "dd-mm-yyyy HH:mm:ss")
	private String completedAt;
	private String status;
	private int totalBookQty;
	private int countedQty;
	private int varianceQty;
	private int recountVarianceQty;
	private String reCount;
	private int reCountQty;

	public int getReCountQty() {
		return reCountQty;
	}

	public void setReCountQty(int reCountQty) {
		this.reCountQty = reCountQty;
	}

	public SaveStockCountInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getRecountVarianceQty() {
		return recountVarianceQty;
	}

	public void setRecountVarianceQty(int recountVarianceQty) {
		this.recountVarianceQty = recountVarianceQty;
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

	public String getStartedAt() {
		return startedAt;
	}

	public void setStartedAt(String startedAt) {
		this.startedAt = startedAt;
	}

	public String getCompletedAt() {
		return completedAt;
	}

	public void setCompletedAt(String completedAt) {
		this.completedAt = completedAt;
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

	public String getReCount() {
		return reCount;
	}

	public void setReCount(String reCount) {
		this.reCount = reCount;
	}

	public SaveStockCountInfo(int countId, String countDescription, String startedAt, String completedAt, String status,
			int totalBookQty, int countedQty, int varianceQty, int recountVarianceQty, String reCount, int reCountQty) {
		super();
		this.countId = countId;
		this.countDescription = countDescription;
		this.startedAt = startedAt;
		this.completedAt = completedAt;
		this.status = status;
		this.totalBookQty = totalBookQty;
		this.countedQty = countedQty;
		this.varianceQty = varianceQty;
		this.recountVarianceQty = recountVarianceQty;
		this.reCount = reCount;
		this.reCountQty = reCountQty;
	}

	@Override
	public String toString() {
		return "SaveStockCountInfo [countId=" + countId + ", countDescription=" + countDescription + ", startedAt="
				+ startedAt + ", completedAt=" + completedAt + ", status=" + status + ", totalBookQty=" + totalBookQty
				+ ", countedQty=" + countedQty + ", varianceQty=" + varianceQty + "]";
	}

}
