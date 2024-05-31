
package com.inventory.purchaseorder.service;

import java.util.List;

import com.inventory.purchaseorder.dto.SaveStockCountCombinedDto;
import com.inventory.purchaseorder.dto.StockCountOnloadDto;
import com.inventory.purchaseorder.entity.AdhocStockCount;
import com.inventory.purchaseorder.entity.SaveStockCountInfo;
import com.inventory.purchaseorder.entity.SaveStockCountProducts;

public interface SaveStockCountService {

	StockCountOnloadDto getStockCountInfo();

	List<SaveStockCountProducts> getStockCountProductsByCountId(int id);

	SaveStockCountCombinedDto saveProducts(SaveStockCountCombinedDto saveStockCountCombinedDto);

	SaveStockCountCombinedDto saveRecountProducts(SaveStockCountCombinedDto saveStockCountCombinedDto);

	// Adhoc count save

	String saveAdhocStockCount(List<AdhocStockCount> adhocStockCount);

	List<AdhocStockCount> getAllAdhocStockCount();

	String saveRecountAdhocStockCount(List<AdhocStockCount> adhocStockCount);

	List<AdhocStockCount> getStockCountProductsByAdhocId(int id);

}
