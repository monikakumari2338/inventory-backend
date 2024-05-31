package com.inventory.purchaseorder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.purchaseorder.entity.StockCountCreation;
import com.inventory.purchaseorder.entity.StockCountCreationProducts;

public interface StockCreationProductsRepo extends JpaRepository<StockCountCreationProducts, Integer> {

	List<StockCountCreationProducts> findByStockcount(StockCountCreation stockCountCreation);
}