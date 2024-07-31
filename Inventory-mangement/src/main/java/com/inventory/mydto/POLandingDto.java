package com.inventory.mydto;

import java.time.LocalDate;

public class POLandingDto {

	private String id;
	private LocalDate date;
	private String status;
	private int totalSku;
	private int totalItems;
	private int asnCount;
	private int pendingQty;
	private int expectedQty;
	private int receivedQty;
	private int damageQty;
	private String supplierId;
	private String type;

	public POLandingDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getTotalSku() {
		return totalSku;
	}

	public void setTotalSku(int totalSku) {
		this.totalSku = totalSku;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public int getAsnCount() {
		return asnCount;
	}

	public void setAsnCount(int asnCount) {
		this.asnCount = asnCount;
	}

	public int getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}

	public int getPendingQty() {
		return pendingQty;
	}

	public void setPendingQty(int pendingQty) {
		this.pendingQty = pendingQty;
	}

	public int getExpectedQty() {
		return expectedQty;
	}

	public void setExpectedQty(int expectedQty) {
		this.expectedQty = expectedQty;
	}

	public int getReceivedQty() {
		return receivedQty;
	}

	public void setReceivedQty(int receivedQty) {
		this.receivedQty = receivedQty;
	}

	public int getDamageQty() {
		return damageQty;
	}

	public void setDamageQty(int damageQty) {
		this.damageQty = damageQty;
	}

	public POLandingDto(String id, LocalDate date, String status, int totalSku, int totalItems, int asnCount,
			int pendingQty, int expectedQty, int receivedQty, int damageQty, String supplierId, String type) {
		super();
		this.id = id;
		this.date = date;
		this.status = status;
		this.totalSku = totalSku;
		this.totalItems = totalItems;
		this.asnCount = asnCount;
		this.pendingQty = pendingQty;
		this.expectedQty = expectedQty;
		this.receivedQty = receivedQty;
		this.damageQty = damageQty;
		this.supplierId = supplierId;
		this.type = type;
	}

}
