package com.inventory.purchaseorder.dto;

import java.util.List;

public class StockCountCreationCombinedDto {

	private StockCountCreationdto creationdto;
	private List<StockCountCreationProductsdto> creationProductsdto;

	public StockCountCreationdto getCreationdto() {
		return creationdto;
	}

	public void setCreationdto(StockCountCreationdto creationdto) {
		this.creationdto = creationdto;
	}

	public List<StockCountCreationProductsdto> getCreationProductsdto() {
		return creationProductsdto;
	}

	public void setCreationProductsdto(List<StockCountCreationProductsdto> creationProductsdto) {
		this.creationProductsdto = creationProductsdto;
	}

}
