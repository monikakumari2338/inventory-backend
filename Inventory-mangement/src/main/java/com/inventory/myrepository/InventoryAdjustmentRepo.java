package com.inventory.myrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.myentity.InventoryAdjustment;

public interface InventoryAdjustmentRepo extends JpaRepository<InventoryAdjustment, String> {

	InventoryAdjustment findByAdjId(String id);

	List<InventoryAdjustment> findAllByOrderByDateDesc();

	List<InventoryAdjustment> findAllByOrderByDateAsc();

}
