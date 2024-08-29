
package com.inventory.myservice;

import java.util.List;

import com.inventory.mydto.DSDLandingDto;
import com.inventory.mydto.InventoryAdjustmentCombinedDto;
import com.inventory.mydto.StockCountAdhocCreationCombinedDto;
import com.inventory.mydto.StockCountCreationDto;
import com.inventory.mydto.StockCountUpdateCombinedDto;

public interface StockCountCreationService {

	List<DSDLandingDto> getAllStockCount();

	InventoryAdjustmentCombinedDto getStockCountProductsByCountId(String countId);

	String updateStockCount(StockCountUpdateCombinedDto StockCountUpdateCombinedDto);

	List<String> getScReasonCodes();

	String createAdhocstockCount(String storeName);

	String saveAdhocProducts(StockCountAdhocCreationCombinedDto adhocDto);

	String createSystemStockCount(String storeName);

	String saveSystemCountProducts(StockCountCreationDto creationDto);

	List<DSDLandingDto> sortStockCountsByLatest();

	List<DSDLandingDto> sortStockCountsByOldest();

	List<DSDLandingDto> filterStockCountsByReasonOrStatus(String param);

	List<DSDLandingDto> getMatchedStockCounts(String countId);

}
