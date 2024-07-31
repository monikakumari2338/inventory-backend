
package com.inventory.myservice;

import java.util.List;
import java.util.Map;

import com.inventory.mydto.DSDLandingDto;
import com.inventory.mydto.DsdCombinedDto;
import com.inventory.mydto.DsdDto;
import com.inventory.mydto.DsdItemsdto;
import com.inventory.mydto.InventoryAdjustmentCombinedDto;
import com.inventory.mydto.SuppliersProductsDto;
import com.inventory.myentity.SuppliersProducts;

public interface DSDService {

	String saveDsd(DsdCombinedDto dsdCombinedDto);

	List<DSDLandingDto> getAllDSd();

	DsdDto createDsd(String storeName, String user);

	DsdCombinedDto getDsdProductsByID(String id);

	List<DSDLandingDto> sortDsdByLatest();

	List<DSDLandingDto> sortDsdByOldest();

	List<DSDLandingDto> filtersBySupplier(String name);

	List<DSDLandingDto> getMatchedDSD(String dsdNumber);

	String SaveSupplierProducts(List<SuppliersProductsDto> suppliersProducts);

	Map<String, String> getMatchedSuppliers(String name);

	String deleteByDsdNumber(String dsdNumber);

	String DsdSaveAsDraft(DsdCombinedDto dsdCombinedDto);

	List<DsdItemsdto> getSearchedItemInDsd(String id, String sku);

	InventoryAdjustmentCombinedDto getItemsToAdd(String supplierName, String sku, String storeName);

	List<String> getMatchedSuppliersBySupplierId(String id);

	// List<DsdItemsGetdto> getDamageDSdItems(int dsdNumber);

}
