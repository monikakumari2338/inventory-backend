package com.inventory.purchaseorder.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class RTVInfo {

	@Id
	private String rtvID;
	private int supplierId;
	private int storeId;
	private int totalSku;
	private LocalDate createdDate;
	private String createdBy;
	private String status;
	private String defaultReasonCode;
	private String dispatchedUser;
	private LocalDate dispatchedDate;

	public String getRtvID() {
		return rtvID;
	}

	public void setRtvID(String rtvID) {
		this.rtvID = rtvID;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public int getTotalSku() {
		return totalSku;
	}

	public void setTotalSku(int totalSku) {
		this.totalSku = totalSku;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDefaultReasonCode() {
		return defaultReasonCode;
	}

	public void setDefaultReasonCode(String defaultReasonCode) {
		this.defaultReasonCode = defaultReasonCode;
	}

	public String getDispatchedUser() {
		return dispatchedUser;
	}

	public void setDispatchedUser(String dispatchedUser) {
		this.dispatchedUser = dispatchedUser;
	}

	public LocalDate getDispatchedDate() {
		return dispatchedDate;
	}

	public void setDispatchedDate(LocalDate dispatchedDate) {
		this.dispatchedDate = dispatchedDate;
	}

	public RTVInfo(String rtvID, int supplierId, int storeId, int totalSku, LocalDate createdDate, String createdBy,
			String status, String defaultReasonCode, String dispatchedUser, LocalDate dispatchedDate) {
		super();
		this.rtvID = rtvID;
		this.supplierId = supplierId;
		this.storeId = storeId;
		this.totalSku = totalSku;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.status = status;
		this.defaultReasonCode = defaultReasonCode;
		this.dispatchedUser = dispatchedUser;
		this.dispatchedDate = dispatchedDate;
	}

	public RTVInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

}
