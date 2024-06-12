package com.inventory.mydto;

import java.time.LocalDate;

public class TsfHeadDto {

	private String storeFrom;
	private String storeTo;
	private String reasonCode;
	private String status;
	private String attachedProof;
	private int totalReqQty;
	private LocalDate creationDate;
	// private LocalDate approvedDate;
	private LocalDate notAfter;
	private LocalDate notBefore;
//	private LocalDate deliveryDate;
//	private LocalDate closedDate;

	public String getStoreFrom() {
		return storeFrom;
	}

	public void setStoreFrom(String storeFrom) {
		this.storeFrom = storeFrom;
	}

	public String getStoreTo() {
		return storeTo;
	}

	public void setStoreTo(String storeTo) {
		this.storeTo = storeTo;
	}

	public String getReasonCode() {
		return reasonCode;
	}

	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAttachedProof() {
		return attachedProof;
	}

	public void setAttachedProof(String attachedProof) {
		this.attachedProof = attachedProof;
	}

	public int getTotalReqQty() {
		return totalReqQty;
	}

	public void setTotalReqQty(int totalReqQty) {
		this.totalReqQty = totalReqQty;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public LocalDate getNotAfter() {
		return notAfter;
	}

	public void setNotAfter(LocalDate notAfter) {
		this.notAfter = notAfter;
	}

	public LocalDate getNotBefore() {
		return notBefore;
	}

	public void setNotBefore(LocalDate notBefore) {
		this.notBefore = notBefore;
	}

	public TsfHeadDto(String storeFrom, String storeTo, String reasonCode, String status, String attachedProof,
			int totalReqQty, LocalDate creationDate, LocalDate notAfter, LocalDate notBefore) {
		super();
		this.storeFrom = storeFrom;
		this.storeTo = storeTo;
		this.reasonCode = reasonCode;
		this.status = status;
		this.attachedProof = attachedProof;
		this.totalReqQty = totalReqQty;
		this.creationDate = creationDate;
		this.notAfter = notAfter;
		this.notBefore = notBefore;

	}

	public TsfHeadDto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
