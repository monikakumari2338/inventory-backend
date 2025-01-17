package com.inventory.rtv.jpa.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class RTVInfo {

	@Size(min = 1, max = 20)
	@NotBlank
	@Id
	private String rtvID;
	@Size(min = 1, max = 10)
	@NotBlank
	private String supplierId;
	@Size(min = 1, max = 30)
	@NotBlank
	private String supplierName;
	private int storeId;
	private int totalSku;
	private int totalItems;
	private LocalDate creationDate;
	private String createdBy;
	@Size(min = 1, max = 20)
	@NotBlank
	private String status;
	@Size(min = 1, max = 30)
	@NotBlank
	private String defaultReasonCode;
	@Size(min = 1, max = 30)
	@NotBlank
	private String dispatchedUser;
	private LocalDate dispatchedDate;
	private String proof;

	@OneToMany(mappedBy = "rtvInfo", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<RTVProducts> rtvProducts;

	public String getRtvID() {
		return rtvID;
	}

	public void setRtvID(String rtvID) {
		this.rtvID = rtvID;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
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

	public int getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}

	public RTVInfo(String rtvID, String supplierId, String supplierName, int storeId, LocalDate creationDate,
			String createdBy, String status, String defaultReasonCode, String dispatchedUser, LocalDate dispatchedDate,
			String proof) {
		super();
		this.rtvID = rtvID;
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.storeId = storeId;
//		this.totalSku = totalSku;
//		this.totalItems = totalItems;
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
