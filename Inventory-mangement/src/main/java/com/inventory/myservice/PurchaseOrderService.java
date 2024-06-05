
package com.inventory.myservice;

import java.util.List;

import com.inventory.mydto.ASNCombinedDto;
import com.inventory.mydto.ASNOnLoadDto;
import com.inventory.mydto.ASNPOItemDetailsDto;
import com.inventory.mydto.AsnAndPOCombinedDto;
import com.inventory.mydto.PurchaseOrderCombinedDto;
import com.inventory.mydto.PurchaseOrderCombineddtotoSave;
import com.inventory.mydto.PurchaseOrderGetdto;
import com.inventory.mydto.PurchaseOrderItemsGetDto3;
import com.inventory.mydto.PurchaseOrderItemsdto;
import com.inventory.myentity.ASN;
import com.inventory.myentity.ASNPOItemDetails;
import com.inventory.myentity.DraftPurchaseOrderItems;
import com.inventory.myentity.PurchaseOrderItems;

public interface PurchaseOrderService {

	PurchaseOrderCombinedDto savePurchaseOrder(PurchaseOrderCombinedDto combinedDto, String pO_ID);

	ASNCombinedDto saveASN(ASNCombinedDto asnCombinedDto, String asnId);

	// AsnAndPOCombinedDto getAllPOAndASN();

//	String saveDamagedPoItems(List<PoDamagedItemsList> poDamagedItemsList);
//
//	List<PoDamagedItemsList> getDamagedPoItemsByAsnOrPo(int number);

	String savePoToMaster(PurchaseOrderCombineddtotoSave combinedDto, String storeName);

	String saveDraftPoItems(List<DraftPurchaseOrderItems> DraftPurchaseOrderItems);

	List<PurchaseOrderItemsdto> getPoItemsSummaryByPoNumber(String poNumber);

	List<PurchaseOrderGetdto> getAllPO();

	String generateRandomString();

	List<PurchaseOrderItemsdto> getPoItemsByPoNumber(String poNumber);

	String generateAsnIdString();

	List<ASNPOItemDetailsDto> getPoItemsByAsnNumber(String asnNumber);

	List<PurchaseOrderItemsGetDto3> getPoItemDetailsByAsnNumber(String asnNumber);

	List<ASNOnLoadDto> getAsnByPoNumber(String PoNumber);

	List<DraftPurchaseOrderItems> getDraftPoItemsByAsn(String number);

	ASNPOItemDetails getProductFromAsnTable(String sku, String asnNumber);

	PurchaseOrderItems getProductFromPoTable(String sku, String poNumber);

}
