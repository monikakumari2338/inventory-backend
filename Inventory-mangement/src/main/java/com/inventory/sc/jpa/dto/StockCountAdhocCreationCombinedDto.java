package com.inventory.sc.jpa.dto;

import java.time.LocalDate;
import java.util.List;

// This dto has been used to save and update adhoc count products  
public class StockCountAdhocCreationCombinedDto {

	private String id;
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

	public StockCountAdhocCreationCombinedDto(String id, LocalDate startDate, LocalDate endDate, String category,
			List<StockCountUpdateProductsDto> items) {
		super();
		this.id = id;
		this.category = category;
		this.items = items;
	}

}
