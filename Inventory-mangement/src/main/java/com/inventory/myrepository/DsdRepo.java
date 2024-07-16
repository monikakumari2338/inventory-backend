package com.inventory.myrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.myentity.DSD;
import com.inventory.myentity.InventoryAdjustment;

public interface DsdRepo extends JpaRepository<DSD, Integer> {

	DSD findFirstByOrderByDsdNumberDesc();

	DSD findByDsdNumber(String id);

	List<DSD> findAllByOrderByCreationDateDesc();

	List<DSD> findAllByOrderByCreationDateAsc();

	List<DSD> findAllBySupplierName(String name);

	List<DSD> findByDsdNumberContaining(String dsd);
}
