package com.inventory.myrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.myentity.InventoryAdjustment;

import jakarta.transaction.Transactional;

public interface InventoryAdjustmentRepo extends JpaRepository<InventoryAdjustment, String> {

	InventoryAdjustment findByAdjId(String id);

	List<InventoryAdjustment> findAllByOrderByDateDesc();

	List<InventoryAdjustment> findAllByOrderByDateAsc();

	List<InventoryAdjustment> findByReasonOrStatus(String reason, String status);

	List<InventoryAdjustment> findByAdjIdContaining(String id);

	@Transactional
	void deleteByAdjId(String adjId);
}
