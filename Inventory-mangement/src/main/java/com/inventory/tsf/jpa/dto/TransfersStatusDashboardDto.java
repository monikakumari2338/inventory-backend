package com.inventory.tsf.jpa.dto;

import java.util.List;

public class TransfersStatusDashboardDto {

	private List<Long> transfersRequest;
	private List<Long> transferFulfillment;

	public TransfersStatusDashboardDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Long> getTransfersRequest() {
		return transfersRequest;
	}

	public void setTransfersRequest(List<Long> transfersRequest) {
		this.transfersRequest = transfersRequest;
	}

	public List<Long> getTransferFulfillment() {
		return transferFulfillment;
	}

	public void setTransferFulfillment(List<Long> transferFulfillment) {
		this.transferFulfillment = transferFulfillment;
	}

	public TransfersStatusDashboardDto(List<Long> transfersRequest, List<Long> transferFulfillment) {
		super();
		this.transfersRequest = transfersRequest;
		this.transferFulfillment = transferFulfillment;
	}

}
