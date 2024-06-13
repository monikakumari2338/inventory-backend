package com.inventory.myentity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TsfHead {

	@Id
	private String tsfId;
	private String storeFrom;
	private String storeTo;
	private String reasonCode;
	private String status;
	private String attachedProof;
	private int totalReqQty;
	private LocalDate creationDate;
	private LocalDate approvedDate;
	private LocalDate notAfter;
	private LocalDate notBefore;
	private LocalDate deliveryDate;
	private LocalDate closedDate;

	public String getTsfId() {
		return tsfId;
	}

	public void setTsfId(String tsfId) {
		this.tsfId = tsfId;
	}

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

	public LocalDate getApprovedDate() {
		return approvedDate;
	}

	public void setApprovedDate(LocalDate approvedDate) {
		this.approvedDate = approvedDate;
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

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public LocalDate getClosedDate() {
		return closedDate;
	}

	public void setClosedDate(LocalDate closedDate) {
		this.closedDate = closedDate;
	}

	public TsfHead(String tsfId, String storeFrom, String storeTo, String reasonCode, String status,
			String attachedProof, int totalReqQty, LocalDate creationDate, LocalDate approvedDate, LocalDate notAfter,
			LocalDate notBefore, LocalDate deliveryDate, LocalDate closedDate) {
		super();
		this.tsfId = tsfId;
		this.storeFrom = storeFrom;
		this.storeTo = storeTo;
		this.reasonCode = reasonCode;
		this.status = status;
		this.attachedProof = attachedProof;
		this.totalReqQty = totalReqQty;
		this.creationDate = creationDate;
		this.approvedDate = approvedDate;
		this.notAfter = notAfter;
		this.notBefore = notBefore;
		this.deliveryDate = deliveryDate;
		this.closedDate = closedDate;
	}

	public TsfHead() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "TsfHead [tsfId=" + tsfId + ", storeFrom=" + storeFrom + ", storeTo=" + storeTo + ", reasonCode="
				+ reasonCode + ", status=" + status + ", attachedProof=" + attachedProof + ", totalReqQty="
				+ totalReqQty + ", creationDate=" + creationDate + ", approvedDate=" + approvedDate + ", notAfter="
				+ notAfter + ", notBefore=" + notBefore + ", deliveryDate=" + deliveryDate + ", closedDate="
				+ closedDate + "]";
	}

}
