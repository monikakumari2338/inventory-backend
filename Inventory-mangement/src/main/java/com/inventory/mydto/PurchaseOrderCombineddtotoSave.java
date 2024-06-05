package com.inventory.mydto;

import java.util.List;

public class PurchaseOrderCombineddtotoSave {

	private String attachedImage;
	private String asnNumber;
	private List<PurchaseOrderItemsSaveDto> purchaseOrderItemsdto;

	public String getAttachedImage() {
		return attachedImage;
	}

	public String getAsnNumber() {
		return asnNumber;
	}

	public void setAsnNumber(String asnNumber) {
		this.asnNumber = asnNumber;
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

	public PurchaseOrderCombineddtotoSave(String attachedImage, String asnNumber,
			List<PurchaseOrderItemsSaveDto> purchaseOrderItemsdto) {
		super();
		this.attachedImage = attachedImage;
		this.asnNumber = asnNumber;
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
