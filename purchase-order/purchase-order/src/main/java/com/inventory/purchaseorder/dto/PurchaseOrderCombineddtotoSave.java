package com.inventory.purchaseorder.dto;

import java.util.List;

public class PurchaseOrderCombineddtotoSave {

	private String attachedImage;
	private List<PurchaseOrderItemsSaveDto> purchaseOrderItemsdto;

	public String getAttachedImage() {
		return attachedImage;
	}

	public void setAttachedImage(String attachedImage) {
		this.attachedImage = attachedImage;
	}

	public List<PurchaseOrderItemsSaveDto> getPurchaseOrderItemsdto() {
		return purchaseOrderItemsdto;
	}

	public void setPurchaseOrderItemsdto(List<PurchaseOrderItemsSaveDto> purchaseOrderItemsdto) {
		this.purchaseOrderItemsdto = purchaseOrderItemsdto;
	}

	public PurchaseOrderCombineddtotoSave(String attachedImage, List<PurchaseOrderItemsSaveDto> purchaseOrderItemsdto) {
		super();
		this.attachedImage = attachedImage;
		this.purchaseOrderItemsdto = purchaseOrderItemsdto;
	}

	public PurchaseOrderCombineddtotoSave() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "PurchaseOrderCombineddtotoSave [attachedImage=" + attachedImage + ", purchaseOrderItemsdto="
				+ purchaseOrderItemsdto + "]";
	}

}
