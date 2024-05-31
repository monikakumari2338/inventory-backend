
package com.inventory.purchaseorder.service;

import java.util.List;


import com.inventory.purchaseorder.dto.ASNCombinedDto;
import com.inventory.purchaseorder.dto.ASNPOItemDetailsDto;
import com.inventory.purchaseorder.dto.AsnAndPOCombinedDto;
import com.inventory.purchaseorder.dto.PurchaseOrderCombinedDto;
import com.inventory.purchaseorder.dto.PurchaseOrderCombineddtotoSave;
import com.inventory.purchaseorder.dto.PurchaseOrderItemsGetDto3;
import com.inventory.purchaseorder.dto.PurchaseOrderItemsdto;
import com.inventory.purchaseorder.entity.DraftPurchaseOrderItems;

public interface PurchaseOrderService {

	PurchaseOrderCombinedDto savePurchaseOrder(PurchaseOrderCombinedDto combinedDto);

	ASNCombinedDto saveASN(ASNCombinedDto asnCombinedDto);

	AsnAndPOCombinedDto getAllPOAndASN();

	List<PurchaseOrderItemsdto> getPoItemsByPoNumber(int poNumber);

	List<ASNPOItemDetailsDto> getPoItemsByAsnNumber(int asnNumber);

//	String saveDamagedPoItems(List<PoDamagedItemsList> poDamagedItemsList);
//
//	List<PoDamagedItemsList> getDamagedPoItemsByAsnOrPo(int number);

	String savePoToMaster(PurchaseOrderCombineddtotoSave combinedDto, String storeName);

	List<PurchaseOrderItemsGetDto3> getPoItemDetailsByAsnNumber(int asnNumber);

	String saveDraftPoItems(List<DraftPurchaseOrderItems> DraftPurchaseOrderItems);

	List<DraftPurchaseOrderItems> getDraftPoItemsByAsnOrPo(int number);

	List<PurchaseOrderItemsdto> getPoItemsSummaryByPoNumber(int poNumber);


}
