
package com.inventory.myservice;

import java.time.LocalDate;

import java.util.List;

import com.inventory.mydto.SCLandingDto;
import com.inventory.mydto.StockCountAdhocCreationCombinedDto;
import com.inventory.mydto.StockCountCombinedDto;
import com.inventory.mydto.StockCountCreationDto;
import com.inventory.mydto.StockCountUpdateCombinedDto;

public interface StockCountCreationService {

	List<SCLandingDto> getAllStockCount();

	StockCountCombinedDto getStockCountProductsByCountId(String countId);

	String updateStockCount(StockCountUpdateCombinedDto StockCountUpdateCombinedDto);

	List<String> getScReasonCodes();

	String saveAdhocProducts(StockCountAdhocCreationCombinedDto adhocDto);

	String saveSystemCountProducts(StockCountCreationDto creationDto);

	List<SCLandingDto> sortStockCountsByLatest();

	List<SCLandingDto> sortStockCountsByOldest();

	List<SCLandingDto> filterStockCountsByReasonOrStatus(String param);

	List<SCLandingDto> getMatchedStockCounts(String countId);

	String draftStockCount(StockCountAdhocCreationCombinedDto ScUpdateCombinedDto, String countType);

	String createSystemStockCount(String storeName, LocalDate startDate, LocalDate endDate);

	StockCountCombinedDto createAdhocstockCount(String storeName, LocalDate startDate, LocalDate endDate);

}
