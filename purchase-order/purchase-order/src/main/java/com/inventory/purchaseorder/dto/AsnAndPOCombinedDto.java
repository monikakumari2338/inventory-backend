package com.inventory.purchaseorder.dto;

import java.util.List;

public class AsnAndPOCombinedDto {

	private List<ASNOnLoadDto> ASN;
	private List<PurchaseOrderGetdto> PurchaseOrder;

	public List<ASNOnLoadDto> getASN() {
		return ASN;
	}

	public void setASN(List<ASNOnLoadDto> aSN) {
		ASN = aSN;
	}

	public List<PurchaseOrderGetdto> getPurchaseOrder() {
		return PurchaseOrder;
	}

	public void setPurchaseOrder(List<PurchaseOrderGetdto> purchaseOrder) {
		PurchaseOrder = purchaseOrder;
	}

	public AsnAndPOCombinedDto(List<ASNOnLoadDto> aSN, List<PurchaseOrderGetdto> purchaseOrder) {
		super();
		ASN = aSN;
		PurchaseOrder = purchaseOrder;
	}

	public AsnAndPOCombinedDto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
