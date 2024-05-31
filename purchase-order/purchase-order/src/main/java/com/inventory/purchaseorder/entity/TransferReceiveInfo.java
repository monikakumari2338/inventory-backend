//package com.inventory.purchaseorder.entity;
//
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Table;
//
//@Entity
//public class TransferReceiveInfo {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int transferId;
//	private int storeFrom;
//	private int storeTo;
//	private int expected_qty;
//	private int received_qty;
//	private String status;
//
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "asnId", referencedColumnName = "asnId")
//	private ASN asn;
//
//	public int getTransferId() {
//		return transferId;
//	}
//
//	public void setTransferId(int transferId) {
//		this.transferId = transferId;
//	}
//
//	public int getStoreFrom() {
//		return storeFrom;
//	}
//
//	public void setStoreFrom(int storeFrom) {
//		this.storeFrom = storeFrom;
//	}
//
//	public int getStoreTo() {
//		return storeTo;
//	}
//
//	public void setStoreTo(int storeTo) {
//		this.storeTo = storeTo;
//	}
//
//	public ASN getAsn() {
//		return asn;
//	}
//
//	public void setAsn(ASN asn) {
//		this.asn = asn;
//	}
//
//	public int getExpected_qty() {
//		return expected_qty;
//	}
//
//	public void setExpected_qty(int expected_qty) {
//		this.expected_qty = expected_qty;
//	}
//
//	public int getReceived_qty() {
//		return received_qty;
//	}
//
//	public void setReceived_qty(int received_qty) {
//		this.received_qty = received_qty;
//	}
//
//	public String getStatus() {
//		return status;
//	}
//
//	public void setStatus(String status) {
//		this.status = status;
//	}
//
//	public TransferReceiveInfo(int storeFrom, int storeTo, int expected_qty, int received_qty, String status, ASN asn) {
//		super();
//		this.storeFrom = storeFrom;
//		this.storeTo = storeTo;
//		this.expected_qty = expected_qty;
//		this.received_qty = received_qty;
//		this.status = status;
//		this.asn = asn;
//	}
//
//	@Override
//	public String toString() {
//		return "TransferReceiveInfo [transferId=" + transferId + ", storeFrom=" + storeFrom + ", storeTo=" + storeTo
//				+ ", expected_qty=" + expected_qty + ", received_qty=" + received_qty + ", status=" + status + ", asn="
//				+ asn + "]";
//	}
//
//	public TransferReceiveInfo() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//}
