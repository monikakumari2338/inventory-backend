
package com.inventory.myservice;

import java.util.List;

import com.inventory.mydto.ASNCombinedDto;
import com.inventory.mydto.ASNPOItemDetailsDto;
import com.inventory.mydto.AsnAndPOCombinedDto;
import com.inventory.mydto.PurchaseOrderCombinedDto;
import com.inventory.mydto.PurchaseOrderCombineddtotoSave;
import com.inventory.mydto.PurchaseOrderItemsGetDto3;
import com.inventory.mydto.PurchaseOrderItemsdto;
import com.inventory.myentity.DraftPurchaseOrderItems;

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
