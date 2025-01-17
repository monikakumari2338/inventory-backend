package com.inventory.myrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.inventory.adjustments.jpa.entity.InventoryAdjustment;

import jakarta.transaction.Transactional;

public interface InventoryAdjustmentRepo extends JpaRepository<InventoryAdjustment, String> {

	InventoryAdjustment findByAdjId(String id);

	List<InventoryAdjustment> findAllByOrderByDateDesc();

	List<InventoryAdjustment> findAllByOrderByDateAsc();

	List<InventoryAdjustment> findByReasonOrStatus(String reason, String status);

	List<InventoryAdjustment> findByAdjIdContaining(String id);

	@Transactional
	void deleteByAdjId(String adjId);

	@Query("SELECT a FROM InventoryAdjustment a WHERE a.invProducts IS EMPTY")
	List<InventoryAdjustment> findAllWithoutInvProducts();

}
