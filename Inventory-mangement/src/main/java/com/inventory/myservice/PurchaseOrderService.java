
package com.inventory.myservice;

import java.util.List;

import com.inventory.mydto.ASNCombinedDto;
import com.inventory.mydto.ASNDto;
import com.inventory.mydto.ASNOnLoadDto;
import com.inventory.mydto.ASNPOItemDetailsDto;
import com.inventory.mydto.DSDLandingDto;
import com.inventory.mydto.InventoryAdjustmentCombinedDto;
import com.inventory.mydto.POLandingDto;
import com.inventory.mydto.PurchaseOrderCombinedDto;
import com.inventory.mydto.PurchaseOrderCombineddtotoSave;
import com.inventory.mydto.PurchaseOrderGetProductDto;
import com.inventory.mydto.PurchaseOrderGetdto;
import com.inventory.myentity.ASNPOItemDetails;
import com.inventory.myentity.DraftPurchaseOrderItems;
import com.inventory.myentity.PurchaseOrderItems;

public interface PurchaseOrderService {

	PurchaseOrderCombinedDto savePurchaseOrder(PurchaseOrderCombinedDto combinedDto, String pO_ID);

	String saveASN(ASNCombinedDto asnCombinedDto, String asnId);

	String savePoToMaster(PurchaseOrderCombineddtotoSave combinedDto, String storeName);

	// String saveDraftPoItems(List<DraftPurchaseOrderItems>
	// DraftPurchaseOrderItems);

	List<POLandingDto> getAllPO();

	String generateRandomString();

	String generateAsnIdString();

	List<ASNPOItemDetailsDto> getPoItemsByAsnNumber(String asnNumber);

	List<ASNOnLoadDto> getAsnByPoNumber(String PoNumber);

	List<ASNPOItemDetails> getAllProductFromAsnTable(String asnNumber);

	List<POLandingDto> sortPoByOldest();

	List<POLandingDto> sortPoByLatest();

	List<POLandingDto> getMatchedPo(String poNumber);

	List<POLandingDto> filtersByStatusOrSupplierName(String param);

	String draftASN(ASNCombinedDto asnCombinedDto, String asnId);

	PurchaseOrderGetProductDto getProductFromPoTable(String sku, String poNumber, String type);

}
