package com.inventory.myrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.sc.jpa.entity.StockCountCreation;
import com.inventory.sc.jpa.entity.StockCountCreationProducts;

import jakarta.transaction.Transactional;

public interface StockCreationProductsRepo extends JpaRepository<StockCountCreationProducts, Integer> {

	List<StockCountCreationProducts> findByStockcount(StockCountCreation stockCountCreation);

	StockCountCreationProducts findByStockcountAndSku(StockCountCreation stockcount, String sku);

	@Transactional
	void deleteAllByStockcount(StockCountCreation stockCount);

}