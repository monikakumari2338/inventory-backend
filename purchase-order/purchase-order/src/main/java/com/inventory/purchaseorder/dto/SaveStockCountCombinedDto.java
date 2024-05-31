package com.inventory.purchaseorder.dto;

import java.util.List;

public class SaveStockCountCombinedDto {

	private SaveStockCountInfodto saveStockCountInfo;
	private List<SaveStockCountProductsdto> saveStockCountProducts;

	public SaveStockCountInfodto getSaveStockCountInfo() {
		return saveStockCountInfo;
	}

	public void setSaveStockCountInfo(SaveStockCountInfodto saveStockCountInfo) {
		this.saveStockCountInfo = saveStockCountInfo;
	}

	public List<SaveStockCountProductsdto> getSaveStockCountProducts() {
		return saveStockCountProducts;
	}

	public void setSaveStockCountProducts(List<SaveStockCountProductsdto> saveStockCountProducts) {
		this.saveStockCountProducts = saveStockCountProducts;
	}

	public SaveStockCountCombinedDto(SaveStockCountInfodto saveStockCountInfo,
			List<SaveStockCountProductsdto> saveStockCountProducts) {
		super();
		this.saveStockCountInfo = saveStockCountInfo;
		this.saveStockCountProducts = saveStockCountProducts;
	}

	@Override
	public String toString() {
		return "SaveStockCountCombinedDto [saveStockCountInfo=" + saveStockCountInfo + ", saveStockCountProducts="
				+ saveStockCountProducts + "]";
	}

}
