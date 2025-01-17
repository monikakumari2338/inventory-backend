
package com.inventory.rtv.service;

import java.util.List;

import com.inventory.adjustments.jpa.dto.InventoryAdjustmentCombinedDto;
import com.inventory.dsd.jpa.dto.DSDLandingDto;
import com.inventory.rtv.jpa.dto.RtvCombinedDto;
import com.inventory.rtv.jpa.dto.RtvGetItemsDto;
import com.inventory.rtv.jpa.dto.RtvInfoDto;
import com.inventory.rtv.jpa.entity.RtvReasonCodes;

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
