
package com.inventory.myservice;

import java.util.List;

import com.inventory.mydto.InventoryAdjustmentCombinedDto;
import com.inventory.mydto.InventoryAdjustmentLandingDto;
import com.inventory.mydto.InventoryAdjustmentProductsdto;
import com.inventory.mydto.InventoryAdjustmentdto;
import com.inventory.myentity.InventoryAdjustment;
import com.inventory.myentity.InventoryAdjustmentProducts;

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
