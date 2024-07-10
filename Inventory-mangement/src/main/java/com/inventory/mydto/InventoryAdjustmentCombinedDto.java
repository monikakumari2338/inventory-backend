package com.inventory.mydto;

import java.util.List;

public class InventoryAdjustmentCombinedDto {

	private String id;
	private String imageData;
	private int totalSku;
	private String reason;
	private String status;
	private List<InventoryAdjustmentProductsdto> items;

	public String getImageData() {
		return imageData;
	}

	public void setImageData(String imageData) {
		this.imageData = imageData;
	}

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public InventoryAdjustmentCombinedDto(String id, String imageData, int totalSku, String reason, String status,
			List<InventoryAdjustmentProductsdto> items) {
		super();
		this.id = id;
		this.imageData = imageData;
		this.totalSku = totalSku;
		this.reason = reason;
		this.status = status;
		this.items = items;
	}

}
