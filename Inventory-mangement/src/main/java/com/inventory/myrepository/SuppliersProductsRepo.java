package com.inventory.myrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.dsd.jpa.entity.Suppliers;
import com.inventory.dsd.jpa.entity.SuppliersProducts;

public interface SuppliersProductsRepo extends JpaRepository<SuppliersProducts, Integer> {

	List<SuppliersProducts> findBySkuContainingAndSuppliersAndStore(String sku, Suppliers supplier, String storeName);

	SuppliersProducts findBySkuAndSuppliers(String sku, Suppliers suppliers);

	SuppliersProducts findBySkuAndSuppliersAndStore(String sku, Suppliers supplier, String storeName);
}
