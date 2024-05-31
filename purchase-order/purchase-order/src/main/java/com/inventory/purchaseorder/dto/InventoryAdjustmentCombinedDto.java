package com.inventory.purchaseorder.dto;

import java.util.List;

public class InventoryAdjustmentCombinedDto {

	private InventoryAdjustmentdto invCombined;
	private List<InventoryAdjustmentProductsdto> productDto;
	public InventoryAdjustmentdto getInvCombined() {
		return invCombined;
	}
	public void setInvCombined(InventoryAdjustmentdto invCombined) {
		this.invCombined = invCombined;
	}
	public List<InventoryAdjustmentProductsdto> getProductDto() {
		return productDto;
	}
	public void setProductDto(List<InventoryAdjustmentProductsdto> productDto) {
		this.productDto = productDto;
	}
	public InventoryAdjustmentCombinedDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public InventoryAdjustmentCombinedDto(InventoryAdjustmentdto invCombined,
			List<InventoryAdjustmentProductsdto> productDto) {
		super();
		this.invCombined = invCombined;
		this.productDto = productDto;
	}
	@Override
	public String toString() {
		return "InventoryAdjustmentCombinedDto [invCombined=" + invCombined + ", productDto=" + productDto + "]";
	}
	
	
	
	

}
