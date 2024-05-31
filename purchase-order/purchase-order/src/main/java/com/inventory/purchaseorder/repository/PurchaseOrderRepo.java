package com.inventory.purchaseorder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.purchaseorder.entity.PurchaseOrder;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public interface PurchaseOrderRepo extends JpaRepository<PurchaseOrder, Integer> {

//	public static final EntityManager entityManager = null;
//
	PurchaseOrder findByPoNumber(int id);
//
//	List<PurchaseOrder> findAllByStatus(String status);
//	List<PurchaseOrder> findAll();
//
//	List<PurchaseOrder> findByStatusContaining(String status);
//
//	List<PurchaseOrder> findByPoNumberContaining(String po);

	PurchaseOrder findFirstByOrderByPoNumberDesc();

}