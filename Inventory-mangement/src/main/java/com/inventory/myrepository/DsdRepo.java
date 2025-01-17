package com.inventory.myrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.inventory.adjustments.jpa.entity.InventoryAdjustment;
import com.inventory.dsd.jpa.entity.DSD;

import jakarta.transaction.Transactional;

public interface DsdRepo extends JpaRepository<DSD, Integer> {

	DSD findFirstByOrderByDsdNumberDesc();

	DSD findByDsdNumber(String id);

	List<DSD> findAllByOrderByCreationDateDesc();

	List<DSD> findAllByOrderByCreationDateAsc();

	//List<DSD> findAllBySupplierName(String name);

	List<DSD> findByDsdNumberContaining(String dsd);

	@Transactional
	void deleteByDsdNumber(String dsdNumber);

	@Query("SELECT a FROM DSD a WHERE a.dsdItem IS EMPTY")
	List<DSD> findAllWithoutDsdItem();

	List<DSD> findBySupplierNameOrStatus(String param, String param2);
}
