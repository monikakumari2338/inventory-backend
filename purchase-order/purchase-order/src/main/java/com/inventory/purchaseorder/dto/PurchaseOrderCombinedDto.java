package com.inventory.purchaseorder.dto;

import java.util.List;

public class PurchaseOrderCombinedDto {

	private PurchaseOrderdto PurchaseOrderdto;
	private List<PurchaseOrderItemsdto> PurchaseOrderItemsdto;

	public PurchaseOrderdto getPurchaseOrderdto() {
		return PurchaseOrderdto;
	}

	public void setPurchaseOrderdto(PurchaseOrderdto purchaseOrderdto) {
		PurchaseOrderdto = purchaseOrderdto;
	}

	public List<PurchaseOrderItemsdto> getPurchaseOrderItemsdto() {
		return PurchaseOrderItemsdto;
	}

	public void setPurchaseOrderItemsdto(List<PurchaseOrderItemsdto> purchaseOrderItemsdto) {
		PurchaseOrderItemsdto = purchaseOrderItemsdto;
	}

	public PurchaseOrderCombinedDto(com.inventory.purchaseorder.dto.PurchaseOrderdto purchaseOrderdto,
			List<com.inventory.purchaseorder.dto.PurchaseOrderItemsdto> purchaseOrderItemsdto) {
		super();
		PurchaseOrderdto = purchaseOrderdto;
		PurchaseOrderItemsdto = purchaseOrderItemsdto;
	}

	public PurchaseOrderCombinedDto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
