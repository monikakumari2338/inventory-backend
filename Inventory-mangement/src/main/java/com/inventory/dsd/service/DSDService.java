
package com.inventory.dsd.service;

import java.util.List;
import java.util.Map;

import com.inventory.adjustments.jpa.dto.InventoryAdjustmentCombinedDto;
import com.inventory.adjustments.jpa.dto.InventoryAdjustmentProductsdto;
import com.inventory.dsd.jpa.dto.DSDLandingDto;
import com.inventory.dsd.jpa.dto.DsdCombinedDto;
import com.inventory.dsd.jpa.dto.DsdDto;
import com.inventory.dsd.jpa.dto.DsdItemsdto;
import com.inventory.dsd.jpa.dto.SuppliersProductsDto;
import com.inventory.dsd.jpa.entity.SuppliersProducts;

public interface DSDService {

	String saveDsd(DsdCombinedDto dsdCombinedDto);

	List<DSDLandingDto> getAllDSd();

	DsdDto createDsd(String storeName, String user);

	DsdCombinedDto getDsdProductsByID(String id);

	List<DSDLandingDto> sortDsdByLatest();

	List<DSDLandingDto> sortDsdByOldest();

	List<DSDLandingDto> getMatchedDSD(String dsdNumber);

	String SaveSupplierProducts(List<SuppliersProductsDto> suppliersProducts);

	Map<String, String> getMatchedSuppliers(String name);

	String deleteByDsdNumber(String dsdNumber);

	String DsdSaveAsDraft(DsdCombinedDto dsdCombinedDto);

	List<DsdItemsdto> getSearchedItemInDsd(String id, String sku);

	InventoryAdjustmentCombinedDto getItemsToAdd(String supplierName, String sku, String storeName, String type);

	InventoryAdjustmentCombinedDto getSupplierItem(String supplierName, String sku, String storeName);

	List<DSDLandingDto> filtersBySupplierNameOrStatus(String param);

	// List<String> getMatchedSuppliersBySupplierId(String id);

	// List<DsdItemsGetdto> getDamageDSdItems(int dsdNumber);

}
