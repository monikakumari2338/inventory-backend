package com.inventory.myrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.myentity.StockCountCreation;
import com.inventory.myentity.StockCountCreationProducts;

public interface StockCreationProductsRepo extends JpaRepository<StockCountCreationProducts, Integer> {

	//List<StockCountCreationProducts> findByStockcount(StockCountCreation stockCountCreation);
}