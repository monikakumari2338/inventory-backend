
package com.inventory.myservice;

import java.util.List;

import com.inventory.mydto.SaveStockCountCombinedDto;
import com.inventory.mydto.StockCountOnloadDto;
import com.inventory.myentity.AdhocStockCount;
import com.inventory.myentity.SaveStockCountInfo;
import com.inventory.myentity.SaveStockCountProducts;

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
