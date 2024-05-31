package com.inventory.purchaseorder.dto;

public class TransferReceiveInfodto {

	private int transfer_id;
	private int storeFrom;
	private int storeTo;
	private int expected_qty;
	private int received_qty;
	private String status;
	private int asn_id;

	public int getTransfer_id() {
		return transfer_id;
	}

	public void setTransfer_id(int transfer_id) {
		this.transfer_id = transfer_id;
	}

	public int getStoreFrom() {
		return storeFrom;
	}

	public void setStoreFrom(int storeFrom) {
		this.storeFrom = storeFrom;
	}

	public int getStoreTo() {
		return storeTo;
	}

	public void setStoreTo(int storeTo) {
		this.storeTo = storeTo;
	}

	public int getAsn_id() {
		return asn_id;
	}

	public void setAsn_id(int asn_id) {
		this.asn_id = asn_id;
	}

	public int getExpected_qty() {
		return expected_qty;
	}

	public void setExpected_qty(int expected_qty) {
		this.expected_qty = expected_qty;
	}

	public int getReceived_qty() {
		return received_qty;
	}

	public void setReceived_qty(int received_qty) {
		this.received_qty = received_qty;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public TransferReceiveInfodto(int transfer_id, int storeFrom, int storeTo, int expected_qty, int received_qty,
			String status, int asn_id) {
		super();
		this.transfer_id = transfer_id;
		this.storeFrom = storeFrom;
		this.storeTo = storeTo;
		this.expected_qty = expected_qty;
		this.received_qty = received_qty;
		this.status = status;
		this.asn_id = asn_id;
	}

	@Override
	public String toString() {
		return "TransferReceiveInfodto [transfer_id=" + transfer_id + ", storeFrom=" + storeFrom + ", storeTo="
				+ storeTo + ", expected_qty=" + expected_qty + ", received_qty=" + received_qty + ", status=" + status
				+ ", asn_id=" + asn_id + "]";
	}

	public TransferReceiveInfodto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
