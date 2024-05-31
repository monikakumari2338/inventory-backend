package com.inventory.purchaseorder.dto;

import java.util.ArrayList;
import java.util.List;

import com.inventory.purchaseorder.entity.SaveStockCountInfo;
import com.inventory.purchaseorder.entity.StockCountCreation;

public class StockCountOnloadDto {

	List<StockCountCreation> pendingList = new ArrayList<>();
	List<SaveStockCountInfo> stockCountInfoList = new ArrayList<>();

	public List<StockCountCreation> getPendingList() {
		return pendingList;
	}

	public void setPendingList(List<StockCountCreation> pendingList) {
		this.pendingList = pendingList;
	}

	public List<SaveStockCountInfo> getStockCountInfoList() {
		return stockCountInfoList;
	}

	public void setStockCountInfoList(List<SaveStockCountInfo> stockCountInfoList) {
		this.stockCountInfoList = stockCountInfoList;
	}

	public StockCountOnloadDto(List<StockCountCreation> expiredList, List<SaveStockCountInfo> stockCountInfoList) {
		super();
		this.pendingList = expiredList;
		this.stockCountInfoList = stockCountInfoList;
	}

	public StockCountOnloadDto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
