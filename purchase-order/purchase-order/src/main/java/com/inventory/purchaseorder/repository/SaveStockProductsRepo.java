package com.inventory.purchaseorder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.purchaseorder.entity.SaveStockCountInfo;
import com.inventory.purchaseorder.entity.SaveStockCountProducts;

public interface SaveStockProductsRepo extends JpaRepository<SaveStockCountProducts, Integer> {

	List<SaveStockCountProducts> findByStockcount(SaveStockCountInfo saveStockCountInfo);
}