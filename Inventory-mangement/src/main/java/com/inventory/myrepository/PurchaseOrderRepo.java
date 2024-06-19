package com.inventory.myrepository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inventory.myentity.AdhocStockCount;
import com.inventory.myentity.PurchaseOrder;
import com.inventory.myentity.TsfHead;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public interface PurchaseOrderRepo extends JpaRepository<PurchaseOrder, Integer> {

//	public static final EntityManager entityManager = null;
//
	PurchaseOrder findByPoNumber(String id);
//
//	List<PurchaseOrder> findAllByStatus(String status);
//	List<PurchaseOrder> findAll();
//
//	List<PurchaseOrder> findByStatusContaining(String status);
//
//	List<PurchaseOrder> findByPoNumberContaining(String po);

	PurchaseOrder findFirstByOrderByPoNumberDesc();

	List<PurchaseOrder> findByCreationDateBetweenAndStoreLocation(LocalDate startDate, LocalDate endDate, String store);

//	@Query("SELECT e FROM PurchaseOrder e WHERE STR_TO_DATE(SUBSTRING(e.creationDate, 1, 10), '%d-%m-%Y') BETWEEN STR_TO_DATE(:startDate, '%d-%m-%Y') AND STR_TO_DATE(:endDate, '%d-%m-%Y')")
//	List<PurchaseOrder> findByDateRange(@Param("startDate") String startDate, @Param("endDate") String endDate);

}