package com.inventory.sc.jpa.dto;

import java.util.List;

// This dto has been used to update the quantity in stock count
public class StockCountUpdateCombinedDto {

	private String id;
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

	public StockCountUpdateCombinedDto(String id, List<StockCountUpdateProductsDto> items) {
		super();
		this.id = id;
		this.items = items;
	}

}
