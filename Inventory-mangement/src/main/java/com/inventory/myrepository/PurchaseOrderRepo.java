package com.inventory.myrepository;

import java.time.LocalDate;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.po.jpa.entity.PurchaseOrder;

public interface PurchaseOrderRepo extends JpaRepository<PurchaseOrder, Integer> {

//	public static final EntityManager entityManager = null;
//
	PurchaseOrder findByPoNumber(String id);

	PurchaseOrder findFirstByOrderByPoNumberDesc();

	List<PurchaseOrder> findByCreationDateBetweenAndStoreLocation(LocalDate startDate, LocalDate endDate, String store);

	List<PurchaseOrder> findAllByOrderByCreationDateAsc();

	List<PurchaseOrder> findAllByOrderByCreationDateDesc();

	List<PurchaseOrder> findByStatusOrSupplierName(String param, String param2);

	List<PurchaseOrder> findByPoNumberContaining(String poNumber);

	List<PurchaseOrder> findAllByStoreLocation(String store);

//	@Query("SELECT e FROM PurchaseOrder e WHERE STR_TO_DATE(SUBSTRING(e.creationDate, 1, 10), '%d-%m-%Y') BETWEEN STR_TO_DATE(:startDate, '%d-%m-%Y') AND STR_TO_DATE(:endDate, '%d-%m-%Y')")
//	List<PurchaseOrder> findByDateRange(@Param("startDate") String startDate, @Param("endDate") String endDate);

}