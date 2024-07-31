package com.inventory.myentity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class RTVInfo {

	@Id
	private String rtvID;
	private int supplierId;
	private String supplierName;
	private int storeId;
	private int totalSku;
	private int total;
	private LocalDate creationDate;
	private String createdBy;
	private String status;
	private String defaultReasonCode;
	private String dispatchedUser;
	private LocalDate dispatchedDate;
	private String proof;

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

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
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

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
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

	public String getProof() {
		return proof;
	}

	public void setProof(String proof) {
		this.proof = proof;
	}

	public RTVInfo(String rtvID, int supplierId, String supplierName, int storeId, int totalSku, int total,
			LocalDate creationDate, String createdBy, String status, String defaultReasonCode, String dispatchedUser,
			LocalDate dispatchedDate, String proof) {
		super();
		this.rtvID = rtvID;
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.storeId = storeId;
		this.totalSku = totalSku;
		this.total = total;
		this.creationDate = creationDate;
		this.createdBy = createdBy;
		this.status = status;
		this.defaultReasonCode = defaultReasonCode;
		this.dispatchedUser = dispatchedUser;
		this.dispatchedDate = dispatchedDate;
		this.proof = proof;
	}

	public RTVInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

}
