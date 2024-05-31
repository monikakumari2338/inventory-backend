package com.inventory.myrepository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.mydto.InventoryAdjustmentProductsdto;
import com.inventory.myentity.InventoryAdjustment;
import com.inventory.myentity.InventoryAdjustmentProducts;

public interface InventoryAdjustmentProductsRepo extends JpaRepository<InventoryAdjustmentProducts, Integer> {

	List<InventoryAdjustmentProducts> findByInvAdjustment(InventoryAdjustment inventoryAdjustment);

//	void saveAll(List<InventoryAdjustmentProductsdto> productDto);
//
//	void save(InventoryAdjustmentProductsdto inventoryAdjustmentProductsdto);
}
