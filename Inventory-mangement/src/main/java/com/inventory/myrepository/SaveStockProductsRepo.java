package com.inventory.myrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.myentity.SaveStockCountInfo;
import com.inventory.myentity.SaveStockCountProducts;

public interface SaveStockProductsRepo extends JpaRepository<SaveStockCountProducts, Integer> {

	List<SaveStockCountProducts> findByStockcountAndStore(SaveStockCountInfo saveStockCountInfo, String store);

	List<SaveStockCountProducts> findByStockcount(SaveStockCountInfo saveStockCountInfo);
}