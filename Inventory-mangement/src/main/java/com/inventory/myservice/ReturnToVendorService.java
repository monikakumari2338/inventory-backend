
package com.inventory.myservice;

import java.util.List;

import com.inventory.mydto.DSDLandingDto;
import com.inventory.mydto.InventoryAdjustmentCombinedDto;
import com.inventory.mydto.RtvCombinedDto;
import com.inventory.mydto.RtvGetItemsDto;
import com.inventory.mydto.RtvInfoDto;
import com.inventory.myentity.RtvReasonCodes;

public interface ReturnToVendorService {

	RtvInfoDto createRTV(String storeName, String user);

	List<String> getRtvReasonCodes();

	String saveRtvProducts(RtvCombinedDto rtvCombinedDto);

	List<DSDLandingDto> getAllVendorReturn();

	List<DSDLandingDto> sortRtvByLatest();

	List<DSDLandingDto> sortRtvByOldest();

	RtvGetItemsDto getRTVProductsbyId(String rtvId, String store);

	List<DSDLandingDto> getMatchedRtvByid(String id);

	List<DSDLandingDto> filtersByReasonOrStatus(String param);

	String draftRTV(RtvCombinedDto rtvCombinedDto);

	String deleteRTVbyId(String id);

}
