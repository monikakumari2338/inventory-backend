package com.inventory.myrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.myentity.InventoryAdjustment;
import com.inventory.myentity.InventoryAdjustmentProducts;

public interface InventoryAdjustmentProductsRepo extends JpaRepository<InventoryAdjustmentProducts, Integer> {

	List<InventoryAdjustmentProducts> findByInvAdjustment(InventoryAdjustment inventoryAdjustment);

	List<InventoryAdjustmentProducts> findByInvAdjustmentAndItemNameContaining(InventoryAdjustment inventoryAdjustment,
			String name);

	List<InventoryAdjustmentProducts> findByInvAdjustmentAndSkuContaining(InventoryAdjustment inventoryAdjustment,
			String sku);

//	void saveAll(List<InventoryAdjustmentProductsdto> productDto);
//
//	void save(InventoryAdjustmentProductsdto inventoryAdjustmentProductsdto);
}
