package com.inventory.purchaseorder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.purchaseorder.entity.Suppliers;

public interface DsdSuppliersRepo extends JpaRepository<Suppliers, Integer> {

	Suppliers findBySupplierId(int supplier);

	List<Suppliers> findAll();
	Suppliers findBysupplierName(String supplier);
}
