
package com.inventory.po.service;

import java.util.List;

import com.inventory.adjustments.jpa.dto.InventoryAdjustmentCombinedDto;
import com.inventory.dsd.jpa.dto.DSDLandingDto;
import com.inventory.po.jpa.dto.ASNCombinedDto;
import com.inventory.po.jpa.dto.ASNDto;
import com.inventory.po.jpa.dto.ASNOnLoadDto;
import com.inventory.po.jpa.dto.ASNPOItemDetailsDto;
import com.inventory.po.jpa.dto.POLandingDto;
import com.inventory.po.jpa.dto.PurchaseOrderCombinedDto;
import com.inventory.po.jpa.dto.PurchaseOrderCombineddtotoSave;
import com.inventory.po.jpa.dto.PurchaseOrderGetProductDto;
import com.inventory.po.jpa.dto.PurchaseOrderGetdto;
import com.inventory.po.jpa.entity.ASNPOItemDetails;
import com.inventory.po.jpa.entity.DraftPurchaseOrderItems;
import com.inventory.po.jpa.entity.PurchaseOrderItems;

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
