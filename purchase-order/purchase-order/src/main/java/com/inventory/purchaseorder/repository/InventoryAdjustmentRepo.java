package com.inventory.purchaseorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.purchaseorder.entity.InventoryAdjustment;

public interface InventoryAdjustmentRepo extends JpaRepository<InventoryAdjustment, String> {

	InventoryAdjustment findByAdjId(String id);

}
