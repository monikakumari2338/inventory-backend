package com.inventory.myrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.dsd.jpa.entity.Suppliers;

public interface SuppliersRepo extends JpaRepository<Suppliers, Integer> {

	List<Suppliers> findBySupplierNameContaining(String name);

	Suppliers findBySupplierId(String supplierId);
}
