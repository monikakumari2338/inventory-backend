
package com.inventory.adjustments.service;

import java.util.List;

import com.inventory.adjustments.jpa.dto.InventoryAdjustmentCombinedDto;
import com.inventory.adjustments.jpa.dto.InventoryAdjustmentLandingDto;
import com.inventory.adjustments.jpa.dto.InventoryAdjustmentProductsdto;
import com.inventory.adjustments.jpa.dto.InventoryAdjustmentdto;
import com.inventory.adjustments.jpa.entity.InventoryAdjustment;
import com.inventory.adjustments.jpa.entity.InventoryAdjustmentProducts;

public interface InventoryAdjustmentService {

	List<String> getAllReasonCodes();

	List<InventoryAdjustmentLandingDto> getAllInventoryAdjustment();

	InventoryAdjustmentCombinedDto getInventoryAdjustmentProductsByID(String id);

	InventoryAdjustmentdto createInventoryAdjustment(String storeName, String user);

	String saveInventoryAdjustmentProducts(InventoryAdjustmentCombinedDto InvAdjCombinedDto);

	List<InventoryAdjustmentLandingDto> sortInventoryAdjustmentByLatest();

	List<InventoryAdjustmentLandingDto> sortInventoryAdjustmentByOldest();

	List<InventoryAdjustmentLandingDto> filtersByReasonOrStatus(String param);

	List<InventoryAdjustmentLandingDto> getMatchedInvAdjByid(String id);

	List<InventoryAdjustmentProductsdto> getSearchedItemInAdjustment(String id, String sku);

	List<InventoryAdjustmentProductsdto> getSearchedItemInAdjustmentByName(String id, String name);

	String IaSaveAsDraft(InventoryAdjustmentCombinedDto InvAdjCombinedDto);

	String deleteByIaId(String id);

}
