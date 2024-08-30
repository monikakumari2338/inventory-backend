package com.inventory.mydto;

import java.time.LocalDate;
import java.util.List;

// This dto has been used to save and update adhoc count products  
public class StockCountAdhocCreationCombinedDto {

	private String id;
	private LocalDate startDate;
	private LocalDate endDate;
	private String reason;
	private String category;
	private List<StockCountUpdateProductsDto> items;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<StockCountUpdateProductsDto> getItems() {
		return items;
	}

	public void setItems(List<StockCountUpdateProductsDto> items) {
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

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public StockCountAdhocCreationCombinedDto(String id, LocalDate startDate, LocalDate endDate, String reason,
			String category, List<StockCountUpdateProductsDto> items) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.reason = reason;
		this.category = category;
		this.items = items;
	}

	@Override
	public String toString() {
		return "StockCountAdhocCreationCombinedDto [id=" + id + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", reason=" + reason + ", category=" + category + ", items=" + items + "]";
	}

}
