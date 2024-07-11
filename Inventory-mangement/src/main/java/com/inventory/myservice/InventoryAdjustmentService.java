
package com.inventory.myservice;

import java.util.List;

import com.inventory.mydto.InventoryAdjustmentCombinedDto;
import com.inventory.mydto.InventoryAdjustmentLandingDto;
import com.inventory.mydto.InventoryAdjustmentdto;
import com.inventory.myentity.InventoryAdjustment;
import com.inventory.myentity.InventoryAdjustmentProducts;

public interface InventoryAdjustmentService {

	List<String> getAllReasonCodes();

	List<InventoryAdjustmentLandingDto> getAllInventoryAdjustment();

	List<InventoryAdjustmentProducts> getInventoryAdjustmentProductsByID(String id);

	InventoryAdjustmentdto createInventoryAdjustment(String storeName, String user);

	String saveInventoryAdjustmentProducts(InventoryAdjustmentCombinedDto InvAdjCombinedDto);

//	List<InventoryAdjustment> sortInventoryAdjustmentByLatest();
//
//	List<InventoryAdjustment> sortInventoryAdjustmentByOldest();

}
