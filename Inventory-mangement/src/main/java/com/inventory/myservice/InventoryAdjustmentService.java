
package com.inventory.myservice;

import java.time.LocalDate;


import java.util.List;

import com.inventory.mydto.InventoryAdjustmentCombinedDto;
import com.inventory.myentity.InventoryAdjustment;
import com.inventory.myentity.InventoryAdjustmentProducts;
import com.inventory.myentity.ReasonCodes;

public interface InventoryAdjustmentService {

	String saveInventoryAdjustment(InventoryAdjustmentCombinedDto InvAdjCombinedDto);

	List<String> getAllReasonCodes();

	List<InventoryAdjustment> getAllInventoryAdjustment();

	List<InventoryAdjustmentProducts> getInventoryAdjustmentProductsByID(String id);

}
