
package com.inventory.purchaseorder.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.inventory.purchaseorder.dto.StockCountCreationCombinedDto;
import com.inventory.purchaseorder.entity.StockCountCreationProducts;

public interface StockCountCreationService {

	StockCountCreationCombinedDto saveProducts(StockCountCreationCombinedDto StockCountCreationCombinedDto);

//	StockCountCreationCombinedDto getProductsByDate(LocalDate date);

	List<StockCountCreationProducts> getStockCountProductsByCountId(int id);

	StockCountCreationCombinedDto getProductsByDate(LocalDate date, String storeName);

}
