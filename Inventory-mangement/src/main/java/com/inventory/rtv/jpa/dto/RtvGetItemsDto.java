package com.inventory.rtv.jpa.dto;

import java.util.List;

import com.inventory.adjustments.jpa.dto.InventoryAdjustmentProductsdto;

public class RtvGetItemsDto {

	private String id;
	private String imageData;
	private int totalSku;
	private String reason;
	private String supplierId;
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

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public RtvGetItemsDto(String id, String imageData, int totalSku, String reason, String supplierId,
			String status, List<InventoryAdjustmentProductsdto> items) {
		super();
		this.id = id;
		this.imageData = imageData;
		this.totalSku = totalSku;
		this.reason = reason;
		this.supplierId = supplierId;
		this.status = status;
		this.items = items;
	}

	@Override
	public String toString() {
		return "InventoryAdjustmentCombinedDto [id=" + id + ", imageData=" + imageData + ", totalSku=" + totalSku
				+ ", reason=" + reason + ", status=" + status + ", items=" + items + "]";
	}

}
