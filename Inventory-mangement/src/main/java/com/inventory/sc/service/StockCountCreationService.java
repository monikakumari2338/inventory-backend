
package com.inventory.sc.service;

import java.time.LocalDate;

import java.util.List;

import com.inventory.sc.jpa.dto.SCLandingDto;
import com.inventory.sc.jpa.dto.StockCountAdhocCreationCombinedDto;
import com.inventory.sc.jpa.dto.StockCountCombinedDto;
import com.inventory.sc.jpa.dto.StockCountCreationDto;
import com.inventory.sc.jpa.dto.StockCountUpdateCombinedDto;

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
