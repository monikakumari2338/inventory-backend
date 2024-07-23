package com.inventory.myrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.myentity.Suppliers;
import com.inventory.myentity.SuppliersProducts;

public interface SuppliersProductsRepo extends JpaRepository<SuppliersProducts, Integer> {

	SuppliersProducts findBySuppliersAndSku(Suppliers supplier, String sku);

}
