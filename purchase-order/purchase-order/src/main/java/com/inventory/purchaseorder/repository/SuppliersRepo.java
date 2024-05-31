package com.inventory.purchaseorder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.purchaseorder.entity.Product;
import com.inventory.purchaseorder.entity.ReasonCodes;
import com.inventory.purchaseorder.entity.RtvReasonCodes;
import com.inventory.purchaseorder.entity.Suppliers;

public interface SuppliersRepo extends JpaRepository<Suppliers, Integer> {
	
	List<Suppliers> findBySupplierNameContaining(String name);

}
