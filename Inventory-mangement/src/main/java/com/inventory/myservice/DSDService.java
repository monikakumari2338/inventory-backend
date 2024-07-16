
package com.inventory.myservice;

import java.util.List;

import com.inventory.mydto.DSDLandingDto;
import com.inventory.mydto.DsdCombinedDto;
import com.inventory.mydto.DsdDto;

public interface DSDService {

	String saveDsd(DsdCombinedDto dsdCombinedDto);

	List<DSDLandingDto> getAllDSd();

	DsdDto createDsd(String storeName, String user);

	DsdCombinedDto getDsdProductsByID(String id);

	List<DSDLandingDto> sortDsdByLatest();

	List<DSDLandingDto> sortDsdByOldest();

	List<DSDLandingDto> filtersBySupplier(String name);

	List<DSDLandingDto> getMatchedDSD(String dsdNumber);

	// List<DsdItemsGetdto> getDamageDSdItems(int dsdNumber);

}
