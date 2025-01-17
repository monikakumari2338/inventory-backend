package com.inventory.myrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.adjustments.jpa.entity.InventoryAdjustment;
import com.inventory.adjustments.jpa.entity.InventoryAdjustmentProducts;

import jakarta.transaction.Transactional;

public interface InventoryAdjustmentProductsRepo extends JpaRepository<InventoryAdjustmentProducts, Integer> {

	List<InventoryAdjustmentProducts> findByInvAdjustment(InventoryAdjustment inventoryAdjustment);

	List<InventoryAdjustmentProducts> findByInvAdjustmentAndItemNameContaining(InventoryAdjustment inventoryAdjustment,
			String name);

	List<InventoryAdjustmentProducts> findByInvAdjustmentAndSkuContaining(InventoryAdjustment inventoryAdjustment,
			String sku);

	@Transactional
	void deleteAllByInvAdjustment(InventoryAdjustment inventoryAdjustment);

	InventoryAdjustmentProducts findByInvAdjustmentAndSku(InventoryAdjustment inventoryAdjustment, Object object);

//	void saveAll(List<InventoryAdjustmentProductsdto> productDto);
//
//	void save(InventoryAdjustmentProductsdto inventoryAdjustmentProductsdto);
}
