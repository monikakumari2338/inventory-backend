
package com.inventory.purchaseorder.service;

import java.time.LocalDate;

import java.util.List;

import com.inventory.purchaseorder.dto.InventoryAdjustmentCombinedDto;
import com.inventory.purchaseorder.entity.InventoryAdjustment;
import com.inventory.purchaseorder.entity.InventoryAdjustmentProducts;
import com.inventory.purchaseorder.entity.ReasonCodes;

public interface InventoryAdjustmentService {

	String saveInventoryAdjustment(InventoryAdjustmentCombinedDto InvAdjCombinedDto);

	List<String> getAllReasonCodes();

	List<InventoryAdjustment> getAllInventoryAdjustment();

	List<InventoryAdjustmentProducts> getInventoryAdjustmentProductsByID(String id);

}
