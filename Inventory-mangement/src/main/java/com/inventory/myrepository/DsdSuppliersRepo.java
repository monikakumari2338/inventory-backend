package com.inventory.myrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inventory.myentity.Suppliers;

public interface DsdSuppliersRepo extends JpaRepository<Suppliers, Integer> {

	Suppliers findBySupplierId(String supplier);

	List<Suppliers> findAll();

	Suppliers findBysupplierName(String supplier);

	List<Suppliers> findAllBySupplierName(String name);

	List<Suppliers> findBySupplierNameContaining(String name);

	List<Suppliers> findBySupplierIdContaining(String id);
}
