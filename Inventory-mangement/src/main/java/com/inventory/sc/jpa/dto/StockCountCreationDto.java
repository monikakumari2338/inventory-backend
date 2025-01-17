package com.inventory.sc.jpa.dto;

import java.util.List;

// This dto has been used to create system generated stock count
public class StockCountCreationDto {

	private String id;
	private String reason;
	private String category;
	private List<StockCountCreationProductsDto> creationProductsDto;

	public StockCountCreationDto() {
		super();
		// TODO Auto-generated constructor stub
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

	public List<StockCountCreationProductsDto> getCreationProductsDto() {
		return creationProductsDto;
	}

	public void setCreationProductsDto(List<StockCountCreationProductsDto> creationProductsDto) {
		this.creationProductsDto = creationProductsDto;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public StockCountCreationDto(String id, String reason, String category,
			List<StockCountCreationProductsDto> creationProductsDto) {
		super();
		this.id = id;
		this.reason = reason;
		this.category = category;
		this.creationProductsDto = creationProductsDto;
	}

}
