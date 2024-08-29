package com.inventory.mydto;

import java.time.LocalDate;
import java.util.List;

public class StockCountCombinedDto {

	private String id;
	private LocalDate startDate;
	private LocalDate endDate;
	private int totalSku;
	private String reason;
	private List<InventoryAdjustmentProductsdto> items;

	public int getTotalSku() {
		return totalSku;
	}

	public void setTotalSku(int totalSku) {
		this.totalSku = totalSku;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public List<InventoryAdjustmentProductsdto> getItems() {
		return items;
	}

	public void setItems(List<InventoryAdjustmentProductsdto> items) {
		this.items = items;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public StockCountCombinedDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StockCountCombinedDto(String id, LocalDate startDate, LocalDate endDate, int totalSku, String reason,
			List<InventoryAdjustmentProductsdto> items) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.totalSku = totalSku;
		this.reason = reason;
		this.items = items;
	}

}